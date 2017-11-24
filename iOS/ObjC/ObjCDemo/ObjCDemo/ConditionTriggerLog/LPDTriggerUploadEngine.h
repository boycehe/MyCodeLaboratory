//
//  LPDTriggerUploadEngine.h
//  ObjCDemo
//
//  Created by heboyce on 2017/11/20.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LPDTriggerLogModel.h"
#import "LPDTriggerUploadModel.h"

@interface LPDTriggerUploadEngine : NSObject
+ (void)upload:(LPDTriggerLogModel*)model extInfo:(NSArray*)extInfo;
@end
