//
//  LPDTriggerDB.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LPDTriggerDB : NSObject

+ (instancetype)defaultDB;

- (void)writeLog:(NSString*)log key:(NSString*)key;

@end
