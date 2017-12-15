//
//  LPDCTLabel.h
//  CoreText
//
//  Created by 李博 on 2017/7/11.
//  Copyright © 2017年 李博. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface LPDCTLabel : UIView

@property (nonatomic, copy)  NSAttributedString *attributedText;
@property (nonatomic, copy)  NSArray<NSNumber *> *highlightTextIndex;

@property (nonatomic, assign) CGFloat preferredMaxLayoutWidth;

@property (nonatomic, strong) UIColor *pointColor;
@property (nonatomic, assign) CGSize pointSize;

@end
