//
//  AppDelegate+MSTest001.m
//  ObjCDemo
//
//  Created by heboyce on 2017/12/4.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "AppDelegate+MSTest001.h"
#import <objc/message.h>

@implementation AppDelegate (MSTest001)


+ (void)load{
    
//    Method originalMethod = class_getInstanceMethod([AppDelegate class], @selector(application: didFinishLaunchingWithOptions:));
//    Method swizzledMethod = class_getInstanceMethod([AppDelegate class], @selector(ms1_application: didFinishLaunchingWithOptions:));
//    method_exchangeImplementations(originalMethod, swizzledMethod);
    
}

- (BOOL)ms1_application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions{
    
    NSLog(@"ms1");
    return YES;
    
}

@end
