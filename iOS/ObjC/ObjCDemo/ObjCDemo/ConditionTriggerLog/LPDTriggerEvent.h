//
//  LPDTriggerEvent.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/9.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef NS_ENUM(NSUInteger, LPDTriggerEventType) {
    LPDTriggerEventTypeBOOL,
    LPDTriggerEventTypeNULL,
};

typedef NS_ENUM(NSUInteger, LPDTriggerEventValue) {
    LPDTriggerEventValueSuccess,
    LPDTriggerEventValueFail,
};

@interface LPDTriggerEvent : NSObject

/**
 * @param type      事件的类型
 * @param count     一段时间内发生多少次数会上报
 * @param interval  一段时间
 */

+ (LPDTriggerEvent*)eventType:(LPDTriggerEventType)type count:(NSInteger)count periodTime:(NSTimeInterval)interval;

@end
