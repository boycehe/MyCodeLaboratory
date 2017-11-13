//
//  LPDTriggerManager.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "LPDTriggerManager.h"

@implementation LPDTriggerManager

+ (instancetype)defualtCenterManager{
    
    static LPDTriggerManager *shareInstance = nil;
    static dispatch_once_t token;
    dispatch_once(&token, ^{
        shareInstance = [LPDTriggerManager new];
    });
    return shareInstance;
    
}

- (void)addMonitorSEL:(SEL)selector forObj:(NSObject*)obj event:(LPDTriggerEvent*)event{
    
    
    
    
}
@end
