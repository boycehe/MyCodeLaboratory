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

void eventStatisticAnalyse(id self,SEL _cmd ,...){
 
    Class currentCls = [self class];
    object_setClass(self, class_getSuperclass([self class]));
    objc_msgSend(self,@selector(ff),1);
    id objc = objc_getAssociatedObject(self, (__bridge const void*)@"objc");
    //通知观察者 执行方法
    objc_msgSend(objc, @selector(observeValueForKeyPath:ofObject:change:context:),self,@"age", nil, nil);
    //再把当前类改成子类
    object_setClass(self, currentCls);
    
    
    
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
    Method originalMethod = class_getInstanceMethod([obj class], selector);
    NSString *newCls    = [@"lpdTM_" stringByAppendingString:targetCls];
    const char *name = [newCls UTF8String];
    Class    nCls = objc_allocateClassPair([obj class], name, 0);
    class_addMethod(nCls, selector, (IMP)eventStatisticAnalyse, method_getTypeEncoding(originalMethod));
    objc_registerClassPair(nCls);
    object_setClass(obj, nCls);
    
    NSString *notificationSuccessName = [NSString stringWithFormat:@"%@_%@_%@",targetCls,NSStringFromSelector(selector),SuccessSuffix];
    NSString *notificationFailName    = [NSString stringWithFormat:@"%@_%@_%@",targetCls,NSStringFromSelector(selector),FailSuffix];
    
}
@end
