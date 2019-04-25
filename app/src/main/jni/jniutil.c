//
// Created by huangtuo on 2018/9/27.
//

#include"com_brightoilonline_c2b_phone_utils_JniUtil.h"
#include<stdio.h>
#include<stdlib.h>

JNIEXPORT jstring JNICALL  Java_com_brightoilonline_c2b_1phone_utils_JniUtil_getKey  (JNIEnv *env, jobject obj)
{

char* testString2 = ((char[]){'m', 'y', '.', 'i', 'n','t','e', 'r', 'f', 'a', '.', 'n', 'e', 't', '/','p','e', 'n', 'n', 'g', 'o', '?', '#', '@', '\0'});
return (*env)->NewStringUTF(env,testString2);
}

