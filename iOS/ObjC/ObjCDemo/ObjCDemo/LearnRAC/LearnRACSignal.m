//
//  LearnRACSignal.m
//  ObjCDemo
//
//  Created by heboyce on 2018/1/23.
//  Copyright © 2018年 boycehe. All rights reserved.
//

#import "LearnRACSignal.h"
#import <ReactiveObjC/ReactiveObjC.h>
#import <libkern/OSAtomic.h>
#import <stdatomic.h>

@implementation LearnRACSignal

- (id)init{
  
  self = [super init];
  
//  [self demo];
  [self tt];
  
 
  
  return self;
  
}

- (void)tt{
  
  
  //使用volatile关键字声明的变量或对象通常具有与优化、多线程相关的特殊属性
  
  volatile int mm = 12;
  
  //线程安全的原子操作++
  OSAtomicIncrement32Barrier(&mm);
  
  
  
  NSLog(@"1_mm:%zd",mm);
  
  //线程安全的原子操作--
  OSAtomicDecrement32Barrier(&mm);
  
  NSLog(@"2_mm:%zd",mm);
  
  
 // OSAtomicIncrement32Barrier 和 OSAtomicDecrement32Barrier也是原子运算的操作符，分别是+1和-1操作
  
}

//基本使用方法
- (void)demo{
  
  
  RACSignal *signal = [RACSignal createSignal:^RACDisposable * _Nullable(id<RACSubscriber>  _Nonnull subscriber) {
    
    [subscriber sendNext:@1];
    [subscriber sendNext:@2];
    [subscriber sendCompleted];
    
    return [RACDisposable disposableWithBlock:^{
      NSLog(@"dispose");
    }];
  }];
  
  [signal subscribeNext:^(id  _Nullable x) {
    NSLog(@"%@", x);
  }];
  
  
}

@end
