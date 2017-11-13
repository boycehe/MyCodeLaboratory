//
//  LPDTriggerManager.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "LPDTriggerManager.h"
#import <objc/message.h>

#define SuccessSuffix   @"success"
#define FailSuffix      @"fail"

@interface LPDTriggerManager()
@property (nonatomic,strong) NSMutableDictionary         *notificationStoreDic;
@end

@implementation LPDTriggerManager

void eventStatisticAnalyse(id self,SEL _cmd ,int age){
 
    
    
    
}

+ (instancetype)defualtCenterManager{
    
    static LPDTriggerManager *shareInstance = nil;
    static dispatch_once_t token;
    dispatch_once(&token, ^{
        shareInstance = [LPDTriggerManager new];
    });
    return shareInstance;
    
}

- (id)init{
    
    self  = [super init];
    
    _notificationStoreDic = [NSMutableDictionary new];
    
    return self;
    
}

- (void)addMonitorSEL:(SEL)selector forObj:(NSObject*)obj event:(LPDTriggerEvent*)event{
    
    NSString *targetCls = NSStringFromClass([obj class]);
    NSString *newCls    = [@"lpdTM_" stringByAppendingString:targetCls];
    const char *name = [newCls UTF8String];
    Class    nCls = objc_allocateClassPair([obj class], name, 0);
    class_addMethod(nCls, selector, (IMP)eventStatisticAnalyse, "v@;i");
    objc_registerClassPair(nCls);
    object_setClass(obj, nCls);
    
    NSString *notificationSuccessName = [NSString stringWithFormat:@"%@_%@_%@",targetCls,NSStringFromSelector(selector),SuccessSuffix];
    NSString *notificationFailName    = [NSString stringWithFormat:@"%@_%@_%@",targetCls,NSStringFromSelector(selector),FailSuffix];
    
}
@end
