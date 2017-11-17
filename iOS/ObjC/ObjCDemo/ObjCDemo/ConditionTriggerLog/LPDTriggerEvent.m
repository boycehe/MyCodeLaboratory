//
//  LPDTriggerEvent.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/9.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "LPDTriggerEvent.h"

@interface LPDTriggerEvent()

@end

@implementation LPDTriggerEvent

+ (LPDTriggerEvent*)eventType:(LPDTriggerEventType)type count:(NSInteger)count periodTime:(NSTimeInterval)interval{
    
    LPDTriggerEvent *event = [[LPDTriggerEvent alloc] init];
    
    event->_type      = type;
    event->_count     = count;
    event->_interval  = interval;
    
    return event;
}

@end
