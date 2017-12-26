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
#import "LPDFullCameraViewController.h"
#import "TestProgressView.h"
#import "ViewController.h"
#import "AutolayoutViewController.h"
#import "PullRefreshDemoViewController.h"
#import <ReactiveObjC/ReactiveObjC.h>
#import "TTObj.h"
#import "Father.h"
@interface AppDelegate ()

@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Override point for customization after application launch.
    
    /*
  RACSignal *signal = [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
    [subscriber sendNext:@1];
    [subscriber sendNext:@2];
    [subscriber sendNext:@3];
    [subscriber sendNext:@4];
    [subscriber sendCompleted];
    return nil;
  }];
  RACSignal *bindSignal = [signal bind:^RACSignalBindBlock _Nonnull{
    return ^(NSNumber *value, BOOL *stop) {
      value = @(value.integerValue * value.integerValue);
      return [RACSignal return:value];
    };
  }];

  [signal subscribeNext:^(id  _Nullable x) {
    NSLog(@"signal: %@", x);
  }];
     
   [bindSignal subscribeNext:^(id  _Nullable x) {
     NSLog(@"bindSignal: %@", x);
   }];
  
  */
  
  /*
  RACSubject *subject = [RACSubject subject];
  
  // Subscriber 1
  [subject subscribeNext:^(id  _Nullable x) {
    NSLog(@"1st Sub: %@", x);
  }];
  [subject sendNext:@1];
  
  // Subscriber 2
  [subject subscribeNext:^(id  _Nullable x) {
    NSLog(@"2nd Sub: %@", x);
  }];
  [subject sendNext:@2];
  
  // Subscriber 3
  [subject subscribeNext:^(id  _Nullable x) {
    NSLog(@"3rd Sub: %@", x);
  }];
  [subject sendNext:@3];
  [subject sendCompleted];
*/
  /*
  RACBehaviorSubject *subject = [RACBehaviorSubject subject];
  
  [subject subscribeNext:^(id  _Nullable x) {
    NSLog(@"1st Sub: %@", x);
  }];
  [subject sendNext:@1];
  
  [subject subscribeNext:^(id  _Nullable x) {
    NSLog(@"2nd Sub: %@", x);
  }];
  [subject sendNext:@2];
  
  [subject subscribeNext:^(id  _Nullable x) {
    NSLog(@"3rd Sub: %@", x);
  }];
  [subject sendNext:@3];
  [subject sendCompleted];
  
  */
  /*
  RACSequence *sequence = [RACSequence sequenceWithHeadBlock:^id _Nullable{
    return @1;
  } tailBlock:^RACSequence * _Nonnull{
    return [RACSequence sequenceWithHeadBlock:^id _Nullable{
      return @2;
    } tailBlock:^RACSequence * _Nonnull{
      return [RACSequence return:@3];
    }];
  }];
  RACSequence *bindSequence = [sequence bind:^RACSequenceBindBlock _Nonnull{
    return ^(NSNumber *value, BOOL *stop) {
      NSLog(@"RACSequenceBindBlock: %@", value);
      value = @(value.integerValue * 2);
      return [RACSequence return:value];
    };
  }];
  NSLog(@"sequence:     head = (%@), tail=(%@)", sequence.head, sequence.tail);
  NSLog(@"BindSequence: head = (%@), tail=(%@)", bindSequence.head, bindSequence.tail);
  */
  /*
  RACCommand *command = [[RACCommand alloc] initWithSignalBlock:^RACSignal * _Nonnull(NSNumber * _Nullable input) {
    return [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
      NSInteger integer = [input integerValue];
      NSLog(@"input:%zd",integer);
      for (NSInteger i = 0; i < integer; i++) {
        [subscriber sendNext:@(i)];
      }
      [subscriber sendCompleted];
      return nil;
    }];
  }];
  [[command.executionSignals switchToLatest] subscribeNext:^(id  _Nullable x) {
    NSLog(@"%@", x);
  }];
  
  [command execute:@1];
   [command execute:@2];
   [command execute:@3];
   */
//  [RACScheduler.mainThreadScheduler afterDelay:0.1
//                                      schedule:^{
//                                        [command execute:@3];
//                                      }];
//  [RACScheduler.mainThreadScheduler afterDelay:0.2
//                                      schedule:^{
//                                        [command execute:@3];
//                                      }];
 

 
  Father *f = [Father new];
  [f setValue:@"boyce" forKey:@"namef"];

  NSLog(@"father:%@",f.namef);
  
    self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
  
    PullRefreshDemoViewController *v = [[PullRefreshDemoViewController alloc] init];
    self.window.rootViewController = v;
    
    [self.window makeKeyAndVisible];
    
    
    
    
    return YES;
}


- (void)test:(NSMutableArray**)arr{
    
    
    
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
