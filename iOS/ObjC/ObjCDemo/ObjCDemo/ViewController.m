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
#import "son.h"
#import "LPDTriggerLogModel.h"
#import "TestProgressView.h"
#import "LPDCTLabel.h"

@interface ViewController ()
@property (nonatomic,strong) dispatch_queue_t         queue;
@property (nonatomic,strong) NSMutableArray             *threadArr;
@property (nonatomic,assign) NSInteger                  total;
@property (atomic,strong) dispatch_semaphore_t       sema;


@end

@implementation ViewController


- (void)viewDidLoad {
    
    [super viewDidLoad];
    
    LPDCTLabel *label  = [[LPDCTLabel alloc]initWithFrame:CGRectMake(10, 100, 100, 30)];
    label.attributedText = [[NSMutableAttributedString alloc]initWithString:@"寻梦环游记"];
    label.backgroundColor = [UIColor whiteColor];
    [self.view addSubview:label];
    
    
    
    
   
}

- (void)testMultiThread{
    
    
    for (NSInteger index = 0; index < 100; index++) {
        
     
        NSThread *thread = [[NSThread alloc]initWithTarget:self selector:@selector(gcdThread:) object:@(index)];
        
        while (self.threadArr .count >= 10 ) {
           // NSLog(@"线程已满等待释放");
            NSThread *firstThread = [self.threadArr objectAtIndex:0];
            if (firstThread.isFinished) {
             //   NSLog(@"释放线程:%@",firstThread);
                [self.threadArr removeObject:firstThread];
            }else{
                 [NSThread sleepForTimeInterval:0.01];
            }
    
            
        }
        
        [self.threadArr addObject:thread];
        
        [thread start];
        

    }
    
    [NSThread sleepForTimeInterval:5];
    NSLog(@"end total:%zd",self.total);
    
}

- (void)gcdThread:(NSNumber*)number{
    
    dispatch_async(self.queue,^{
        
       dispatch_semaphore_wait(self.sema, DISPATCH_TIME_FOREVER);
        
//        NSInteger a = [number integerValue]%2;
//        NSLog(@"before self.total:%zd",self.total);
//        if (a == 0) {
//            self.total --;
//        }else{
//            self.total++;
//        }
        
        
        
        NSLog(@"%@",number);
        [NSThread sleepForTimeInterval:0.2];
         dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0),^{
             [NSThread sleepForTimeInterval:0.01];
              NSLog(@"--number:%@",number);
         });
     //   NSLog(@"after self.total:%zd",self.total);
       dispatch_semaphore_signal(self.sema);

        
    });
    
}


- (void)addRealmTestData{
    
    
  for (NSInteger index = 0; index < 20; index++) {
      
      LPDTriggerLogModel *model = [LPDTriggerLogModel new];
      
      model.logTag =  @"abcdef_afab";
      model.eventTimestamp = [[NSString stringWithFormat:@"15111603%d",(int)(arc4random()%100)] integerValue];
      model.isUpload = NO;
        
  }
    
}

- (BOOL)sumWithA:(NSInteger)a B:(NSInteger)b C:(NSInteger)c{
    

    return NO;
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
