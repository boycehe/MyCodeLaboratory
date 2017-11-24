//
//  LPDTriggerUploadModel.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/24.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "LPDTriggerUploadModel.h"
#import "LPDTriggerUploadEngine.h"

@implementation LPDTriggerUploadModel

- (void)uploadWithBlock:(LPDUploadResultBlock)block{
    
    if (!self.model || !self.extInfo) {
        return ;
    }
    
    [LPDTriggerUploadEngine upload:self.model extInfo:self.extInfo];
    
}

@end
