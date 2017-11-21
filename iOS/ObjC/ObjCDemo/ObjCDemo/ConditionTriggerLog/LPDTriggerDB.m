//
//  LPDTriggerDB.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "LPDTriggerDB.h"
#import "LPDTriggerLogModel.h"
#import "LPDTriggerUtils.h"
#import <Realm/Realm.h>
#import "LPDTriggerUploadEngine.h"

#define LPDGenerateLogId(cls,sel) ([NSString stringWithFormat:@"%@_%@",NSStringFromClass(cls),NSStringFromSelector(sel)])

@interface LPDTriggerDB()

@end

@implementation LPDTriggerDB

+ (instancetype)defaultDB{
    
    static LPDTriggerDB *shareInstance = nil;
    static dispatch_once_t token;
    dispatch_once(&token, ^{
        shareInstance = [[self alloc] init];
    });
    return shareInstance;
}

- (instancetype)init{
    
    self = [super init];
    
    [self creatDataBaseWithName:@"lpd_trigger_log"];
    
    return self;
    
}

- (void)creatDataBaseWithName:(NSString *)databaseName
{
    NSArray *docPath = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *path = [docPath objectAtIndex:0];
    NSString *filePath = [path stringByAppendingPathComponent:databaseName];
    
    RLMRealmConfiguration *config = [RLMRealmConfiguration defaultConfiguration];
    config.fileURL = [NSURL URLWithString:filePath];
    config.objectClasses = @[LPDTriggerLogModel.class];
    config.readOnly = NO;
    int currentVersion = 1.0;
    config.schemaVersion = currentVersion;
    
    NSLog(@"realm path:%@",filePath);
    
    config.migrationBlock = ^(RLMMigration *migration , uint64_t oldSchemaVersion) {
        // 这里是设置数据迁移的block
        if (oldSchemaVersion < currentVersion) {
        }
    };
    
    [RLMRealmConfiguration setDefaultConfiguration:config];
    
}

- (BOOL)createEvent:(LPDTriggerEvent*)event forClass:(Class)cls sel:(SEL)seloctor{
    
    if (!event || !cls || !seloctor ) {
        return NO;
    }
    
   NSString *logId = LPDGenerateLogId(cls,seloctor);
    
   RLMRealm *rm = [RLMRealm defaultRealm];
   
    RLMResults<LPDTriggerLogModel *> *existModel = [LPDTriggerLogModel objectsWhere:[NSString stringWithFormat:@"logId = '%@'",logId]];
    if (existModel.count >0) {
        return YES;
    }
    
   LPDTriggerLogModel *model = [[LPDTriggerLogModel alloc] init];
   model.logId          = logId;
   model.baseInfo       = [LPDTriggerUtils baseInfo];
   model.eventTimestamp = [[NSDate date] timeIntervalSince1970];
   model.eventType      = event.type;
   model.isUpload       = NO;
   model.count          = event.count;
   model.peroidTime     = event.interval;
   model.isIgnore       = YES;
    
   [rm addObject:model];
    
    return YES;
}

- (BOOL)writeLog:(NSString*)log forClass:(Class)cls sel:(SEL)seloctor{
    
    NSString *logId = LPDGenerateLogId(cls,seloctor);
    
    RLMResults<LPDTriggerLogModel *> *existModel = [LPDTriggerLogModel objectsWhere:[NSString stringWithFormat:@"logId = '%@'",logId]];
    
    if (existModel.count == 0) {
        return NO;
    }
    
    LPDTriggerLogModel *firstExistModel = existModel.firstObject;
    
    
    RLMRealm *rm = [RLMRealm defaultRealm];
   
    LPDTriggerLogModel *model = [[LPDTriggerLogModel alloc] init];
    model.logId          = LPDGenerateLogId(cls, seloctor);
    model.baseInfo       = [LPDTriggerUtils baseInfo];
    model.eventTimestamp = [[NSDate date] timeIntervalSince1970];
    model.eventType      = firstExistModel.eventType;
    model.isUpload       = NO;
    model.count          = firstExistModel.count;
    model.peroidTime     = firstExistModel.peroidTime;
    model.isIgnore       = NO;
  
    [rm addObject:model];
    
    [self checkAndUploadWithModel:model];
    
    return YES;
}

- (void)checkAndUploadWithModel:(LPDTriggerLogModel*)model{
    
    RLMResults<LPDTriggerLogModel *> *existModel = [LPDTriggerLogModel objectsWhere:[NSString stringWithFormat:@"logId = '%@' AND  isUpload = NO",model.logId]];
    
    if (existModel.count <=0) {
        return;
    }
    
    RLMResults<LPDTriggerLogModel *> *sortResults = [existModel sortedResultsUsingKeyPath:@"eventTimestamp" ascending:YES];
    
    LPDTriggerLogModel *firstModel = sortResults.firstObject;
    
    if (firstModel.count > existModel.count) {
        return;
    }
    
    NSMutableArray *dicArr = [NSMutableArray array];
    
    for (NSInteger index = sortResults.count - 1; index >= sortResults.count - firstModel.count; index--) {
        
        LPDTriggerLogModel *m = [sortResults objectAtIndex:index];
        
        NSMutableDictionary *dic = [NSMutableDictionary dictionary];
        [dic setObject:@(m.count) forKey:@"count"];
        [dic setObject:m.extInfo forKey:@"customParameter"];
        [dic setObject:[LPDTriggerUtils netStatusFromBaseInfo:m.baseInfo] forKey:@"networkType"];
        [dic setObject:@(m.eventTimestamp) forKey:@"occurrenceTime"];
        [dic setObject:m.logId forKey:@"tag"];
        [dic setObject:@(m.peroidTime) forKey:@"time"];
    
        [dicArr addObject:dic];
    }
    
    LPDTriggerLogModel *topModel = [sortResults objectAtIndex:sortResults.count-1];
    LPDTriggerLogModel *bottomCountModel = [sortResults objectAtIndex:sortResults.count-firstModel.count];
    NSLog(@"top:%f---bottom:%f",topModel.eventTimestamp,bottomCountModel.eventTimestamp);
    
    if (topModel.eventTimestamp - bottomCountModel.eventTimestamp <= firstModel.peroidTime) {
        NSLog(@"符合要求，准备上传");
      
        [LPDTriggerUploadEngine upload:topModel extInfo:dicArr];
        
        
    }else{
        NSLog(@"不符合要求，等待下次");
    }
    

}


@end
