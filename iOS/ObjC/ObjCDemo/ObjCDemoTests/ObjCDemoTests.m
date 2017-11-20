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
   
     LPDTriggerDB *db = [LPDTriggerDB defaultDB];
    
    for (NSInteger index = 0; index < 20; index++) {
        
        LPDTriggerLogModel *model = [LPDTriggerLogModel new];
        model.logId =  @"abcdef_afab";
        model.eventTimestamp = 1511160300 + (int)(arc4random()%100);
        model.isUpload   = NO;
        model.count      = 5;
        model.peroidTime = 100;
        
        RLMRealm *realm = [RLMRealm defaultRealm];
        [realm transactionWithBlock:^{
            [realm addObject:model];
        }];
        
    }
    
    LPDTriggerLogModel *model = [LPDTriggerLogModel new];
    model.logId =  @"abcdef_afab";

    [db checkAndUploadWithModel:model];
    
}

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    }];
}

@end
