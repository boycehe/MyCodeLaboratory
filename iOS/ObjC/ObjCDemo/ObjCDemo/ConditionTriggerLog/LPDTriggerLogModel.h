//
//  LPDTriggerLogModel.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/17.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface LPDTriggerLogModel : NSObject
@property (nonatomic,copy) NSString         *logId;
/**
 *骑手的账号，手机型号，网络环境 ，app版本，系统版本
 */
@property (nonatomic,copy) NSString         *baseInfo;
/**
 * 发生时候的时间戳
 */
@property (nonatomic,assign) NSTimeInterval         eventTimestamp;
/**
 * 事件类型
 */
@property (nonatomic,assign) NSInteger              eventType;
/**
 * 是否已经上传
 */
@property (nonatomic,assign) BOOL                   isUpload;
/**
 * 错误描述信息
 */
@property (nonatomic,copy) NSString                *extInfo;


@end
