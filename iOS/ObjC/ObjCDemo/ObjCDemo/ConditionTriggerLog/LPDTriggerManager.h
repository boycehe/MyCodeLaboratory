//
//  LPDTriggerManager.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LPDTriggerEvent.h"

#define LPDTriggerEventSuccess  [[LPDTriggerManager defualtCenterManager] \
                                eventWithValue:LPDTriggerEventValueSuccess \
                                forClass:[self Class] Sel:_cmd]

#define LPDTriggerEventFail     [[LPDTriggerManager defualtCenterManager] \
                                eventWithValue:LPDTriggerEventValueFail \
                                forClass:[self Class] Sel:_cmd]


@interface LPDTriggerManager : NSObject

+ (instancetype)defualtCenterManager;
- (void)addMonitorSEL:(SEL)selector forObj:(NSObject*)obj event:(LPDTriggerEvent*)event;
- (void)eventWithValue:(LPDTriggerEventValue)value forClass:(Class)cls Sel:(SEL)selctor;
@end
