//
//  LPDRACRequest.h
//  ObjCDemo
//
//  Created by heboyce on 2017/12/23.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <ReactiveObjC/ReactiveObjC.h>
#import "LPDRequestObject.h"

@interface LPDRACRequest : RACSubject

+ (LPDRACRequest *)add:(LPDRequestObject *)requestObj;

@end
