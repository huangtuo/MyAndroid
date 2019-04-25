package com.demo.ht.myandroid.jni;

/**
 * Created by huangtuo on 2018/9/27.
 */

public class JniUtil {
    static {
        //jniutil这个参数对应着c的文件名，以及后面的配置名以及so的库名称
        System.loadLibrary("jniutil");
    }
    //c/c++中要对应实现的方法，必须声明native
    public native String getKey();
}
