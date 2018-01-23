//
//  LPDSignalPool.h
//  ObjCDemo
//
//  Created by heboyce on 2017/12/28.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <ReactiveObjC/RACSignal.h>

@interface LPDSignalPool : NSObject

+ (nonnull LPDSignalPool *)defaultPool;
+ (nullable RACSignal *)singalWithFormat:(nullable NSString *)format;

@end
