//
//  NSObject+LPDRequest.h
//  ObjCDemo
//
//  Created by heboyce on 2017/12/24.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LPDRACRequest.h"

@interface NSObject (LPDRequest)
@property (nonatomic,strong,readonly) LPDRACRequest         *racRequest;

- (void)request;

@end
