//
//  LPDTriggerLogModel.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/17.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Realm/Realm.h>
#import "LPDTriggerEvent.h"

@interface LPDTriggerLogModel : RLMObject
@property  NSString         *logTag;
/**
 *骑手的账号，手机型号，网络环境 ，app版本，系统版本
 */
@property NSString         *baseInfo;
/**
 * 发生时候的时间戳
 */
@property NSTimeInterval         eventTimestamp;
/**
 * 事件类型
 */
@property NSInteger              eventType;
/**
 * 是否已经上传
 */
@property BOOL                   isUpload;
/**
 * 错误描述信息
 */
@property NSString                *extInfo;
/**
 * 触发上传的阈值的次数
 */
@property NSInteger                count;
/**
 * 触发上传时间段阈值
 */
@property NSTimeInterval            peroidTime;

/**
 * 是否忽略掉该条记录
 */
@property BOOL                      isIgnore;

@end
