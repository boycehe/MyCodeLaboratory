//
//  LPDTriggerUtils.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/17.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LPDTriggerUtils : NSObject

+ (NSString*)baseInfo;
+ (NSString*)osVersionFromBaseInfo:(NSString*)baseInfo;
+ (NSString*)deviceFromBaseInfo:(NSString*)baseInfo;
+ (NSString*)appVersionFromBaseInfo:(NSString*)baseInfo;
+ (NSString*)netStatusFromBaseInfo:(NSString*)baseInfo;
@end
