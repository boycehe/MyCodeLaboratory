//
//  AppDelegate+MSTest002.m
//  ObjCDemo
//
//  Created by heboyce on 2017/12/4.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "AppDelegate+MSTest002.h"
#import <objc/message.h>

@implementation AppDelegate (MSTest002)

+ (void)load{
    
    Method originalMethod = class_getInstanceMethod([AppDelegate class], @selector(application: didFinishLaunchingWithOptions:));
    Method swizzledMethod = class_getInstanceMethod([AppDelegate class], @selector(ms2_application: didFinishLaunchingWithOptions:));
    method_exchangeImplementations(originalMethod, swizzledMethod);
    
}

- (BOOL)ms2_application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions{
    
    NSLog(@"ms2");
    return YES;
    
}

@end
