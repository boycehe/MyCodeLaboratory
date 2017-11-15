//
//  LPDTriggerEvent.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/9.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "LPDTriggerEvent.h"

@interface LPDTriggerEvent()
@property (nonatomic,assign) LPDTriggerEventType         type;
@property (nonatomic,assign) NSInteger                   count;
@property (nonatomic,assign) NSTimeInterval              interval;
@end

@implementation LPDTriggerEvent

+ (LPDTriggerEvent*)eventType:(LPDTriggerEventType)type count:(NSInteger)count periodTime:(NSTimeInterval)interval{
    
    LPDTriggerEvent *event = [[LPDTriggerEvent alloc] init];
    
    event.type      = type;
    event.count     = count;
    event.interval  = interval;
    
    return event;
}

@end
