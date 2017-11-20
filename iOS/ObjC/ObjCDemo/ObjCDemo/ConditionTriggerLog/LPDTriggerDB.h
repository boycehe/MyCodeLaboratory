//
//  LPDTriggerDB.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//


#import <Foundation/Foundation.h>
#import "LPDTriggerEvent.h"
@class LPDTriggerLogModel;

@interface LPDTriggerDB : NSObject

+ (instancetype)defaultDB;

+ (void)testDatas;

- (void)checkAndUploadWithModel:(LPDTriggerLogModel*)model;

@end
