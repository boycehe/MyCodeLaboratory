//
//  TestProgressView.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/29.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import "TestProgressView.h"

@interface TestProgressView()
@property (nonatomic,strong) CALayer         *maskLayer;
@property (nonatomic,strong) CATextLayer     *maskTextLayer;
@property (nonatomic,strong) CATextLayer     *textLayer;

@end

@implementation TestProgressView

- (instancetype)initWithFrame:(CGRect)frame{
    
    self = [super initWithFrame:frame];
    
    [self addSubLayer];
    
    return self;
    
}

- (void)setProgress:(CGFloat)progress{
    
    _progress = progress;
    
    if (_progress <=0) {
        _progress = 0;
    }
    
    if (_progress >=1) {
        _progress = 1;
    }
    
    _maskLayer.frame = CGRectMake(_maskLayer.frame.origin.x, _maskLayer.frame.origin.y, self.frame.size.width*progress, _maskLayer.frame.size.height);
    
}


- (void)addSubLayer{
    
    UIFont *font = [UIFont systemFontOfSize:16.0f];
    
    
    _maskLayer = [[CALayer alloc]init];
    _maskLayer.frame = self.bounds;
    _maskLayer.backgroundColor = [UIColor whiteColor].CGColor;
    _maskLayer.masksToBounds = YES;
    _maskLayer.frame = self.bounds;
    
    _maskTextLayer = [[CATextLayer alloc]init];
    _maskTextLayer.frame = CGRectMake(10, 0, 100, 20);
    _maskTextLayer.foregroundColor = [UIColor redColor].CGColor;
    _maskTextLayer.string= @"hello world";
    _maskTextLayer.fontSize = font.pointSize;
    _maskTextLayer.contentsScale = [UIScreen mainScreen].scale;
   
   
    self.layer.masksToBounds = YES;
    self.layer.cornerRadius = 5;
    self.layer.borderWidth = 1;
    self.layer.borderColor = [UIColor blueColor].CGColor;
    
    
    
    _textLayer = [[CATextLayer alloc]init];
    _textLayer.frame = CGRectMake(10, 0, 100, 20);
     _textLayer.contentsScale = [UIScreen mainScreen].scale;
    _textLayer.string= @"hello world";
    _textLayer.fontSize = font.pointSize;
    _textLayer.foregroundColor = [UIColor blueColor].CGColor;
    
    
    [self.layer addSublayer:_textLayer];
    [self.layer addSublayer:_maskLayer];
    [_maskLayer addSublayer:_maskTextLayer];
    
}

@end
