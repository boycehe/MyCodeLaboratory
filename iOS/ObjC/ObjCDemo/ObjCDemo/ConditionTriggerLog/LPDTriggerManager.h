//
//  LPDTriggerManager.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LPDTriggerEvent.h"
@interface LPDTriggerManager : NSObject
+ (instancetype)defualtCenterManager;
- (void)addMonitorSEL:(SEL)selector forObj:(NSObject*)obj event:(LPDTriggerEvent*)event;
@end
