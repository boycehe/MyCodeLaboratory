//
//  ObjCDemoTests.m
//  ObjCDemoTests
//
//  Created by heboyce on 2017/11/20.
//  Copyright © 2017年 boycehe. All rights reserved.
//

#import <XCTest/XCTest.h>
#import "LPDTriggerLogModel.h"
#import "LPDTriggerDB.h"
#import <AVOSCloud/AVOSCloud.h>

@interface ObjCDemoTests : XCTestCase

@end

@implementation ObjCDemoTests

- (void)setUp {
    [super setUp];
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
    [super tearDown];
}

- (void)testExample {
   
    [AVOSCloud setApplicationId:@"fvoLrzIRocXh0lCyTpNrTUUk-gzGzoHsz" clientKey:@"SNyqfyDcG4yaYsH8iXbXR0jV"];
    
    
    
}

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    }];
}

@end
