//
//  AppDelegate.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/9.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "AppDelegate.h"
#import "LPDTriggerUtils.h"
#import <AVOSCloud/AVOSCloud.h>
#import "LPDTriggerDB.h"
#import "LPDTriggerLogModel.h"

@interface AppDelegate ()

@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Override point for customization after application launch.
    
    [AVOSCloud setApplicationId:@"fvoLrzIRocXh0lCyTpNrTUUk-gzGzoHsz" clientKey:@"SNyqfyDcG4yaYsH8iXbXR0jV"];
    //[AVOSCloud set];
    
    LPDTriggerDB *db = [LPDTriggerDB defaultDB];
    
    for (NSInteger index = 0; index < 20; index++) {
        
        LPDTriggerLogModel *model = [LPDTriggerLogModel new];
        model.logTag =  @"abcdef_afab";
        model.eventTimestamp = 1511160300 + (int)(arc4random()%100);
        model.isUpload   = NO;
        model.count      = 5;
        model.peroidTime = 100;
        model.extInfo = @"hello world";
        model.baseInfo = [LPDTriggerUtils baseInfo];
        
        
        RLMRealm *realm = [RLMRealm defaultRealm];
        [realm transactionWithBlock:^{
            [realm addObject:model];
        }];
        
    }
    
    LPDTriggerLogModel *model = [LPDTriggerLogModel new];
    model.logTag =  @"abcdef_afab";
    
    [db checkAndUploadWithModel:model];
    
    
    return YES;
}


- (void)applicationWillResignActive:(UIApplication *)application {
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
}


- (void)applicationDidEnterBackground:(UIApplication *)application {
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}


- (void)applicationWillEnterForeground:(UIApplication *)application {
    // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
}


- (void)applicationDidBecomeActive:(UIApplication *)application {
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}


- (void)applicationWillTerminate:(UIApplication *)application {
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}


@end
