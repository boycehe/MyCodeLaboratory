//
//  LPDCTLabel.m
//  CoreText
//
//  Created by 李博 on 2017/7/11.
//  Copyright © 2017年 李博. All rights reserved.
//

#import "LPDCTLabel.h"
#import <CoreText/CoreText.h>

@interface LPDCTLabel ()

@end

@implementation LPDCTLabel

- (instancetype)init
{
    self = [super init];
    if (self) {
      
        self.backgroundColor = [UIColor whiteColor];
    }
    return self;
}

- (CGSize)intrinsicContentSize {
    if (self.attributedText.length > 0) {
        CTFramesetterRef framesetter = CTFramesetterCreateWithAttributedString((CFAttributedStringRef)self.attributedText);
        CGSize size = CTFramesetterSuggestFrameSizeWithConstraints(framesetter, CFRangeMake(0, 0), NULL, CGSizeMake(self.preferredMaxLayoutWidth, MAXFLOAT), NULL);
        CFRelease(framesetter);
        
        size.width = self.preferredMaxLayoutWidth;
        size.height += self.pointSize.height;
        
        CGRect rect = self.bounds;
        rect.size = size;
        self.bounds = rect;
        
        return size;
    }
    return CGSizeZero;
}

- (void)drawRect:(CGRect)rect {
    [super drawRect:rect];
    
    [self drawBottomLinePoint];
}

- (void)drawBottomLinePoint {
    CGContextRef contextRef = UIGraphicsGetCurrentContext();
    
    //  NSLog(@"转换前的坐标：%@",NSStringFromCGAffineTransform(CGContextGetCTM(contextRef)));

    
    CGContextSetTextMatrix(contextRef, CGAffineTransformIdentity);
    CGContextTranslateCTM(contextRef, 0, self.bounds.size.height);
    CGContextScaleCTM(contextRef, 1.0, -1.0);
    
    //  NSLog(@"转换后的坐标：%@",NSStringFromCGAffineTransform(CGContextGetCTM(contextRef)));
    
    CGMutablePathRef path = CGPathCreateMutable();
    CGPathAddRect(path, nil, (CGRect){CGPointMake(0, 0),self.bounds.size});
    
    CTFramesetterRef framesetter = CTFramesetterCreateWithAttributedString((CFAttributedStringRef)self.attributedText);
    CTFrameRef frame = CTFramesetterCreateFrame(framesetter, CFRangeMake(0, self.attributedText.length), path, NULL);
    
    //  CTFrameDraw(frame, contextRef);
    
    CFArrayRef linesArray = CTFrameGetLines(frame);
    CFIndex linesCount = CFArrayGetCount(linesArray);
    
    CGPoint origins[linesCount];
    
    CTFrameGetLineOrigins(frame, CFRangeMake(0, 0), origins);
    
    for (CFIndex i = linesCount - 1; i >= 0; i--) {
        CTLineRef line = CFArrayGetValueAtIndex(linesArray, i);
        CGPoint point = origins[i];
        CGContextSetTextPosition(contextRef, point.x, point.y);

        
        //    CTLineDraw(line, contextRef);
        

        CFArrayRef glyphRunsArray = CTLineGetGlyphRuns(line);
        CFIndex glyphRunsCount = CFArrayGetCount(glyphRunsArray);
        for (CFIndex j = 0; j < glyphRunsCount; j++) {
            CTRunRef run = CFArrayGetValueAtIndex(glyphRunsArray, j);
            
            UIColor *backgroundColor = [self getBackgroundColor:run];
            
            CTRunDraw(run, contextRef, CFRangeMake(0, 0));
            
            CFIndex glyphCount = CTRunGetGlyphCount(run);
            CFRange range = CFRangeMake(0, glyphCount);
            
            CGPoint pointArray[glyphCount];
            CGSize sizeArray[glyphCount];
            CFIndex indexArray[glyphCount];
            
          CTRunGetPositions(run, range, pointArray);
            CTRunGetAdvances(run, range, sizeArray);
            CTRunGetStringIndices(run, range, indexArray);
            
            CGFloat ascent = 0;
            CGFloat descent = 0;
            CGFloat leading = 0;
            
            CTRunGetTypographicBounds(run, CFRangeMake(0, 0), &ascent, &descent, &leading);
            
            for (CFIndex k = 0; k < glyphCount; k++) {
                CGPoint currentPoint = pointArray[k];
                CGSize currentSize = sizeArray[k];
                CFIndex currentIndex = indexArray[k];
                
                if ([self.highlightTextIndex containsObject:@(currentIndex)]) {
                    CGRect rect = CGRectMake(currentPoint.x + currentSize.width/2 - self.pointSize.width/2, (point.y - self.pointSize.height - 4), self.pointSize.width, self.pointSize.height);
                    
                    CGContextSetFillColorWithColor(contextRef, self.pointColor.CGColor);
                    CGContextFillEllipseInRect(contextRef, rect);
                }
                
                // draw backgroundColor
                if (backgroundColor) {
                    CGContextSetFillColorWithColor(contextRef, backgroundColor.CGColor);

                    CGContextFillRect(contextRef, (CGRect){CGPointMake(currentPoint.x, point.y - descent),CGSizeMake(currentSize.width, ascent + descent + leading)});

                }
            }
        }
    }
    CFRelease(frame);
    CFRelease(framesetter);
    CFRelease(path);
}

- (void)setAttributedText:(NSAttributedString *)attributedText {
    _attributedText = attributedText;
    
    [self invalidateIntrinsicContentSize];
    [self setNeedsDisplay];
}

- (UIColor *)getBackgroundColor:(CTRunRef)run {
    CFDictionaryRef CFAttributesDic = CTRunGetAttributes(run);
    NSDictionary *NSAttributesDic = (__bridge NSDictionary *)(CFAttributesDic);
    UIColor *backgroundColor = [NSAttributesDic objectForKey:@"NSBackgroundColor"];
    
    if (backgroundColor && [backgroundColor isKindOfClass: UIColor.class]) {
        return backgroundColor;
    }
    return nil;
}

@end

