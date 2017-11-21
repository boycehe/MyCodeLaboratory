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
#import <CoreTelephony/CTTelephonyNetworkInfo.h>
#import <Reachability/Reachability.h>

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
    
    //网络环境
    NSString *netStatus = [self internetStatus];
    addBaseInfoBlock(@"networkType",netStatus);
    
    return baseInfoStr;
    
}

+ (NSString *)internetStatus {
    
    Reachability *reachability   = [Reachability reachabilityWithHostName:@"www.baidu.com"];
    NetworkStatus internetStatus = [reachability currentReachabilityStatus];
    NSString *net = @"WIFI";
    switch (internetStatus) {
        case ReachableViaWiFi:
            net = @"WiFi";
            break;
        case ReachableViaWWAN:
            net = [self wwanStatus];
            break;
        case NotReachable:
            net = @"NoReachable";
        default:
            break;
    }
    
    return net;
}

+ (NSString*)wwanStatus
{
    NSArray *typeStrings2G = @[CTRadioAccessTechnologyEdge,
                               CTRadioAccessTechnologyGPRS,
                               CTRadioAccessTechnologyCDMA1x];
    
    NSArray *typeStrings3G = @[CTRadioAccessTechnologyHSDPA,
                               CTRadioAccessTechnologyWCDMA,
                               CTRadioAccessTechnologyHSUPA,
                               CTRadioAccessTechnologyCDMAEVDORev0,
                               CTRadioAccessTechnologyCDMAEVDORevA,
                               CTRadioAccessTechnologyCDMAEVDORevB,
                               CTRadioAccessTechnologyeHRPD];
    
    NSArray *typeStrings4G = @[CTRadioAccessTechnologyLTE];
    
    if ([[[UIDevice currentDevice] systemVersion] floatValue] >= 7.0) {
        CTTelephonyNetworkInfo *teleInfo= [[CTTelephonyNetworkInfo alloc] init];
        NSString *accessString = teleInfo.currentRadioAccessTechnology;
        if ([typeStrings4G containsObject:accessString]) {
            return @"4G";
        } else if ([typeStrings3G containsObject:accessString]) {
            return @"3G";
        } else if ([typeStrings2G containsObject:accessString]) {
            return @"2G";
        } else {
            return @"unknow";
        }
    } else {
        return @"unknow";
    }
}

+ (NSString*)netStatusFromBaseInfo:(NSString*)baseInfo{
 
    return [self valueForKey:@"networkType" fromBaseInfo:baseInfo];
    
}


+ (NSString*)osVersionFromBaseInfo:(NSString*)baseInfo{
    
    return [self valueForKey:@"system" fromBaseInfo:baseInfo];
    
    
}
+ (NSString*)deviceFromBaseInfo:(NSString*)baseInfo{
    
  return [self valueForKey:@"device" fromBaseInfo:baseInfo];
    
}

+ (NSString*)appVersionFromBaseInfo:(NSString*)baseInfo{
    
    return [self valueForKey:@"appversion" fromBaseInfo:baseInfo];
    
}

+ (NSString*)valueForKey:(NSString*)key fromBaseInfo:(NSString*)baseInfo{
    
    NSString *valueStr = @"";
    
    NSArray *arr = [baseInfo componentsSeparatedByString:@";"];
    for (NSString *str in arr) {
        
        if ([str containsString:key]) {
            
            NSArray *m = [str componentsSeparatedByString:@":"];
            if (m.count == 2) {
                valueStr = [m objectAtIndex:1];
            }
            
        }
        
    }
    
    return valueStr;
    
}

@end
