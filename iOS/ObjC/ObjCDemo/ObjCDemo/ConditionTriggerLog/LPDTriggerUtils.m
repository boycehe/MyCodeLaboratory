//
//  LPDTriggerUtils.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/17.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "LPDTriggerUtils.h"
#import <UIKit/UIKit.h>
#import <sys/utsname.h>

@implementation LPDTriggerUtils
+ (NSString*)baseInfo{
    
   __block NSString *baseInfoStr = @"";
    struct utsname systemInfo;
    uname(&systemInfo);
    
    void (^addBaseInfoBlock)(NSString *name, NSString *str) = ^(NSString *name, NSString *str){
        if (str == nil) {
            str = @"";
        }
        if (name == nil) {
            name = @"";
        }
        
        baseInfoStr = [baseInfoStr stringByAppendingString:[NSString stringWithFormat:@"%@:%@;",name,str]];
    };
    //设备类型
    NSString *platform = [NSString stringWithCString:systemInfo.machine encoding:NSASCIIStringEncoding];
    addBaseInfoBlock(@"device",platform);
    //系统版本
    NSString *sysVersion = [[UIDevice currentDevice] systemVersion];
    addBaseInfoBlock(@"system",sysVersion);
    //app版本号
    NSDictionary *infoDic = [[NSBundle mainBundle] infoDictionary];
    NSString *appVersion = [infoDic objectForKey:@"CFBundleShortVersionString"];
    addBaseInfoBlock(@"appversion",appVersion);
    
    
    return baseInfoStr;
    
}
@end
