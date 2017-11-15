//
//  LPDTriggerManager.m
//  ObjCDemo
//
//  Created by heboyce on 2017/11/13.
//  Copyright © 2017年 boycehe. All rights reserved.
//

/**
 Code    Meaning
 c       A char
 i      An int
 s      A short
 l      A long
 q      A long long
 C      An unsigned char
 I      An unsigned int
 S      An unsigned short
 L      An unsigned long
 Q      An unsigned long long
 f      A float
 d      A double
 B      A C++ bool or a C99 _Bool
 v      A void
 *      A character string (char *)
 @      An object (whether statically typed or typed id)
 #      A class object (Class)
 :      A method selector (SEL)
 [array type]    An array
 {name=type…}    A structure
 (name=type…)    A union
 bnum            A bit field of num bits
 ^type           A pointer to type
 ?    An unknown type (among other things, this code is used for function pointers)
 **/

#import "LPDTriggerManager.h"
#import <objc/message.h>

#define LPDTriggerSuccessSuffix   @"success"
#define LPDTriggerFailSuffix      @"fail"
#define LPDTriggerClassPrefix     @"lpdTM_"

@interface LPDTriggerManager()
@property (nonatomic,strong) NSMutableDictionary         *notificationStoreDic;
@end

@implementation LPDTriggerManager

typedef NS_ENUM(NSUInteger, LPDReturnType) {
    LPDReturnTypeVoid = 11,
    LPDReturnTypeBOOL,
    LPDReturnTypeBase,
    LPDReturnTypePointer,
    LPDReturnTypeObject,
    LPDReturnTypeClass,
    LPDReturnTypeUnKnow,
};

bool startsWith(const char *pre, const char *str){
    size_t lenpre = strlen(pre),
    lenstr = strlen(str);
    return lenstr < lenpre ? false : strncmp(pre, str, lenpre) == 0;
}


LPDReturnType returnType(char *dst){
    
    printf("retun type:%s",dst);
    if (startsWith("v", dst)) {
        
        return LPDReturnTypeVoid;
        
    }else if (startsWith("B", dst)){
        
        return LPDReturnTypeBOOL;
        
    }else if (startsWith("#", dst)){
        
        return LPDReturnTypeClass;
        
    }else if (startsWith("@", dst)){
        
        return LPDReturnTypeObject;
        
    }

    return LPDReturnTypeUnKnow;

}

void eventStatisticAnalyse(id self,SEL _cmd ,va_list argp){
 
    Class currentCls = [self class];
    char dst;
    Method method = class_getInstanceMethod(currentCls,_cmd);
    method_getReturnType(method, &dst, sizeof(char));
    LPDReturnType retType = returnType(&dst);
    object_setClass(self, class_getSuperclass([self class]));
    
    if (retType == LPDReturnTypeBOOL) {
        bool ret = ((BOOL(*)(id, SEL, va_list))(void *)objc_msgSend)(self, _cmd,argp);
    }else{
        objc_msgSend(self, _cmd,argp);
    }
    
    object_setClass(self, currentCls);
   
}



+ (instancetype)defualtCenterManager{
    
    static LPDTriggerManager *shareInstance = nil;
    static dispatch_once_t token;
    dispatch_once(&token, ^{
        shareInstance = [[self alloc] init];
    });
    return shareInstance;
    
}

- (id)init{
    
    self  = [super init];
   
    _notificationStoreDic = [NSMutableDictionary new];
    
    return self;
    
}


- (void)eventWithValue:(LPDTriggerEventValue)value forClass:(Class)cls Sel:(SEL)selctor{
    
    
    
}

- (void)addMonitorSEL:(SEL)selector forObj:(NSObject*)obj event:(LPDTriggerEvent*)event{
    
    NSString *targetCls = NSStringFromClass([obj class]);
    Method originalMethod = class_getInstanceMethod([obj class], selector);
    NSString *newCls    = [LPDTriggerClassPrefix stringByAppendingString:targetCls];
    const char *name = [newCls UTF8String];
    Class    nCls = objc_allocateClassPair([obj class], name, 0);
    class_addMethod(nCls, selector, (IMP)eventStatisticAnalyse, method_getTypeEncoding(originalMethod));
    objc_registerClassPair(nCls);
    object_setClass(obj, nCls);
    
}
@end
