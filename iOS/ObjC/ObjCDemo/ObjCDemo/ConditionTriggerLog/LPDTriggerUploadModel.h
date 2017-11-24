//
//  LPDTriggerUploadModel.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/24.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LPDTriggerLogModel.h"
typedef void (^LPDUploadResultBlock)(BOOL succeeded,  NSError * error);

@interface LPDTriggerUploadModel : NSObject
@property (nonatomic,strong) LPDTriggerLogModel         *model;
@property (nonatomic,strong) NSArray                    *extInfo;

- (void)uploadWithBlock:(LPDUploadResultBlock)block;
@end
