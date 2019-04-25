package com.demo.ht.myandroid.net.retrofit;

/**
 * 请求监听接口
 *
 * @author ZhongDaFeng
 */
public interface HttpRequestListener {

    /**
     * 取消请求
     */
    void cancel();

    /**
     * 请求被取消
     */
    void onCanceled();
}
