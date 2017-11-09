//
//  ViewController.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/9.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "ViewController.h"
#import <JavaScriptCore/JavaScriptCore.h>

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    JSContext *context = [[JSContext alloc] init];
    context[@"sumNums"] = ^(NSInteger a,NSInteger b,NSInteger c){
    NSLog(@"%@_%@_Success",[self class],NSStringFromSelector(_cmd));
        return [self sumWithA:a B:b C:c];
    };
    
    
    JSValue *sum = [context evaluateScript:@"sumNums(7,56,22)"];
    NSLog(@"sum=%@",sum);
    
    SEL sel = @selector(sumWithA:B:C:);
    NSMethodSignature *methodSignature = [self methodSignatureForSelector:sel];
    NSInvocation *invo = [NSInvocation invocationWithMethodSignature:methodSignature];
    [invo setTarget:self];
    [invo setSelector:sel];
    NSInteger a = 1,b = 2,c = 3;
    void *arg2 = &a;
    void *arg3 = &b;
    void *arg4 = &c;
    [invo setArgument:arg2 atIndex:2];
    [invo setArgument:arg3 atIndex:3];
    [invo setArgument:arg4 atIndex:4];
    
    [invo invoke];
    
    void *retP = malloc(sizeof(NSInteger));
    [invo getReturnValue:retP];
    NSInteger ret = *((NSInteger*)retP);
    free(retP);
    NSLog(@"ret=%zd",ret);
    
    
    
}

- (NSInteger)sumWithA:(NSInteger)a B:(NSInteger)b C:(NSInteger)c{
    
    return a+b+c;
    
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
