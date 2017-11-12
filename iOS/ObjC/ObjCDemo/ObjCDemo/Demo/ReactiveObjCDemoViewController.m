//
//  ReactiveObjCDemoViewController.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/10.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "ReactiveObjCDemoViewController.h"
#import <ReactiveObjC/RACSignal.h>
#import <ReactiveObjC/RACDisposable.h>
#import <ReactiveObjC/RACSubscriber.h>

@interface ReactiveObjCDemoViewController ()

@end

@implementation ReactiveObjCDemoViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    //划水
    RACSignal *signal = [RACSignal createSignal:
                         ^RACDisposable *(id<RACSubscriber> subscriber)
    {
        [subscriber sendNext:@1];
        [subscriber sendNext:@2];
        [subscriber sendNext:@3];
        [subscriber sendCompleted];
        return [RACDisposable disposableWithBlock:^{
            NSLog(@"signal dispose");
        }];
    }];
    RACDisposable *disposable = [signal subscribeNext:^(id x) {
        NSLog(@"subscribe value = %@", x);
    } error:^(NSError *error) {
        NSLog(@"error: %@", error);
    } completed:^{
        NSLog(@"completed");
    }];
    
    [disposable dispose];
    
    [self testStr:@"a%@%@%@",@"b",@"c",@"e",nil];
    
  
    
    // Do any additional setup after loading the view.
}

- (void)testStr:(NSString*)format,...{
    
    va_list args;
    va_start(args, format);
    NSString *str = [[NSString alloc] initWithFormat:format arguments:args];
    va_end(args);
    NSLog(@"str:%@\n",str);
    
    
  
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
