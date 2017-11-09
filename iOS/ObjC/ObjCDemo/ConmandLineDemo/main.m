//
//  main.m
//  ConmandLineDemo
//
//  Created by heboyce on 2017/11/9.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        
        int (^sumBlock)(int,int,int) = ^(int a,int b,int c){
            printf("%d\n",(a+b+c));
            return a+b+c;
        };
        sumBlock(1,2,3);
        
        id anyBlock = sumBlock;
        

        ((int (^)(int, int, int))anyBlock)(1,2,3);
        
        
    }
    return 0;
}
