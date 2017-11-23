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
#define LPDTriggerClassPrefix     @"lpdBrYsJ_"

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

void eventClassStatisticAnalyse(id self,SEL _cmd ,va_list argp){
    
     Class currentCls = [self class];
     char dst;
     Method method = class_getClassMethod(currentCls,_cmd);
     method_getReturnType(method, &dst, sizeof(char));
     LPDReturnType retType = returnType(&dst);
     Class superCls = class_getSuperclass(self);
     Class metaClass = objc_getMetaClass(class_getName(self));

    SEL oSel =  NSSelectorFromString([@"MM_" stringByAppendingString:NSStringFromSelector(_cmd)]);
    
    if (retType == LPDReturnTypeBOOL) {
        bool ret = ((BOOL(*)(id, SEL, va_list))(void *)objc_msgSend)(self, oSel,argp);
    }else{
        objc_msgSend(self,oSel,argp);
    }
    
   // object_setClass(self, metaClass);
    
}

void eventInstanceStatisticAnalyse(id self,SEL _cmd ,va_list argp){
 
    Class currentCls = [self class];
    char dst;
    Method method = class_getInstanceMethod(currentCls,_cmd);
    method_getReturnType(method, &dst, sizeof(char));
    LPDReturnType retType = returnType(&dst);
    object_setClass(self, class_getSuperclass([self class]));
    
    NSLog(@"eventInstanceStatisticAnalyse");
    
   
    if (retType == LPDReturnTypeBOOL) {
        bool ret = ((BOOL(*)(id, SEL, va_list))(void *)objc_msgSend)(self, _cmd,argp);
    }else{
        objc_msgSend(self,_cmd,argp);
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

- (void)addMonitorSEL:(SEL)selector forCls:(Class)cls event:(LPDTriggerEvent*)event{
    
    Class nCls = [self classWithName:cls];
    Method orginMethod = class_getClassMethod(cls, selector);
    Class metaCls = objc_getMetaClass(class_getName(cls));
    NSString *nSelector = [@"MM_" stringByAppendingString:NSStringFromSelector(selector)];
    SEL nSel = NSSelectorFromString(nSelector);
    class_addMethod(metaCls,nSel,(IMP)eventClassStatisticAnalyse,method_getTypeEncoding(orginMethod));
    Method nMethod = class_getClassMethod(cls, nSel);
    method_exchangeImplementations(orginMethod,nMethod);
    
  
}

- (void)addMonitorSEL:(SEL)selector forObj:(NSObject*)obj event:(LPDTriggerEvent*)event{
    
    Class orginCls        = [obj class];
    Method originalMethod = class_getInstanceMethod(orginCls, selector);
    Class    nCls         = [self classWithName:orginCls];
    class_addMethod(nCls, selector, (IMP)eventInstanceStatisticAnalyse, method_getTypeEncoding(originalMethod));
    object_setClass(obj, nCls);
    
}

- (Class)classWithName:(Class)orginCls{
    
    NSString *clsName = [LPDTriggerClassPrefix stringByAppendingString:NSStringFromClass(orginCls)];
    Class clazz = NSClassFromString(clsName);

    if (clazz) {
        return clazz;
    }

    const char *name = [clsName UTF8String];
    Class    nCls = objc_allocateClassPair([orginCls class], name, 0);
    objc_registerClassPair(nCls);
    
    
   
    return  nCls;
    
}

- (void)eventWithEvent:(LPDTriggerEvent*)event andTag:(NSString*)tag action:(NSObject<LPDTriggerActionProtocol>*)action{
    
    
}

@end
