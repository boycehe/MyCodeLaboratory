//
//  ViewController.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/9.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "ViewController.h"
#import <JavaScriptCore/JavaScriptCore.h>
#import "LPDTriggerManager.h"
#import "son.h"
#import "LPDTriggerLogModel.h"
#import "TestProgressView.h"

@interface ViewController ()

@end

@implementation ViewController


- (void)viewDidLoad {
    
    [super viewDidLoad];
 
    TestProgressView *view = [[TestProgressView alloc]initWithFrame:CGRectMake(50, 100, 200, 50)];
    view.backgroundColor = [UIColor yellowColor];
    
    [self.view addSubview:view];
    
    [NSTimer scheduledTimerWithTimeInterval:0.5 repeats:YES block:^(NSTimer * _Nonnull timer) {
        view.progress = view.progress+0.01;
    }];
    
   //  [[LPDTriggerManager defualtCenterManager] addMonitorSEL:@selector(sumWithA:B:C:) forObj:self event:nil];
   //  [[LPDTriggerManager defualtCenterManager] addMonitorSEL:@selector(test) forCls:[self class] event:nil];
   //  [NSThread sleepForTimeInterval:2];
    

}

- (void)addRealmTestData{
    
    
  for (NSInteger index = 0; index < 20; index++) {
      
      LPDTriggerLogModel *model = [LPDTriggerLogModel new];
      
      model.logTag =  @"abcdef_afab";
      model.eventTimestamp = [[NSString stringWithFormat:@"15111603%d",(int)(arc4random()%100)] integerValue];
      model.isUpload = NO;
        
  }
    
}

- (BOOL)sumWithA:(NSInteger)a B:(NSInteger)b C:(NSInteger)c{
    

    return NO;
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
