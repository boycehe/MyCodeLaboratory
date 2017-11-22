//
//  LPDTriggerUploadEngine.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/20.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "LPDTriggerUploadEngine.h"
#import <AVOSCloud/AVObject.h>
#import "LPDTriggerUtils.h"

@implementation LPDTriggerUploadEngine
+ (void)upload:(LPDTriggerLogModel*)model extInfo:(NSArray*)extInfo{
    
     AVObject *uploadObj = [AVObject objectWithClassName:@"TimeBomb"];
    
     NSData *extJsonData = [NSJSONSerialization dataWithJSONObject:extInfo options:NSJSONWritingPrettyPrinted error:nil];
     NSString *extStr    = [NSString stringWithUTF8String:[extJsonData bytes]];
    
     [uploadObj setObject:[LPDTriggerUtils appVersionFromBaseInfo:model.baseInfo] forKey:@"appVersion"];
     [uploadObj setObject:@(model.count) forKey:@"count"];
     [uploadObj setObject:extStr forKey:@"customParameter"];
     [uploadObj setObject:@(model.eventTimestamp) forKey:@"occurrenceTime"];
     [uploadObj setObject:[LPDTriggerUtils osVersionFromBaseInfo:model.baseInfo] forKey:@"osVersion"];
     [uploadObj setObject:[LPDTriggerUtils deviceFromBaseInfo:model.baseInfo] forKey:@"phoneModel"];
     [uploadObj setObject:model.logTag forKey:@"tag"];
     [uploadObj setObject:@(model.peroidTime) forKey:@"time"];
    
    [uploadObj saveInBackgroundWithBlock:^(BOOL succeeded, NSError * _Nullable error) {
        
        if (succeeded) {
            NSLog(@"上传成功");
        }else{
            NSLog(@"上传失败:%@",error);
        }
        
    }];
    
    
    
}
@end
