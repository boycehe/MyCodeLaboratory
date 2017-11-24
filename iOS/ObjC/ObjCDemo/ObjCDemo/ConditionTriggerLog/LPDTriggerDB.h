//
//  LPDTriggerDB.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//


#import <Foundation/Foundation.h>
#import "LPDTriggerEvent.h"
#import "LPDTriggerUploadModel.h"
@class LPDTriggerLogModel;

@interface LPDTriggerDB : NSObject

+ (instancetype)defaultDB;

- (LPDTriggerUploadModel*)checkAndUploadWithModel:(LPDTriggerLogModel*)model;

@end
