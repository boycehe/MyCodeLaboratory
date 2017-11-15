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

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    
    [super viewDidLoad];
    
   
   NSLog(@"viewDidLoad--");
    
   [[LPDTriggerManager defualtCenterManager] addMonitorSEL:@selector(sumWithA:B:C:) forObj:self event:nil];
    
    [NSThread sleepForTimeInterval:2];

    [self sumWithA:1 B:2 C:3];
}

- (BOOL)sumWithA:(NSInteger)a B:(NSInteger)b C:(NSInteger)c{
    
    return NO;
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
