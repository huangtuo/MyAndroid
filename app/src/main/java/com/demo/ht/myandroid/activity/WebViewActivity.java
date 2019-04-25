package com.demo.ht.myandroid.activity;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.demo.ht.myandroid.R;
import com.demo.ht.myandroid.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by huangtuo on 2019/3/6.
 */

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initBundleData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        webView.loadUrl("file:///android_asset/open.html");
//        setListener();
    }


        private void setListener() {
            WebSettings setting = webView.getSettings();
            setting.setBuiltInZoomControls(true);
            setting.setUseWideViewPort(true);
            setting.setJavaScriptEnabled(true);
            setting.setCacheMode(WebSettings.LOAD_NO_CACHE);// 不适用缓存
//            wbWebView.addJavascriptInterface(new AppJavaScript(activity, this), "myApp");
//            wbWebView.setWebChromeClient(new MyWebChromeClient());
//            wbWebView.setWebViewClient(new MyWebViewClient());
//            wbWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//            wbWebView.setOnKeyListener(new View.OnKeyListener() {
//                @Override
//                public boolean onKey(View v, int keyCode, KeyEvent event) {
//                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
//                        if (keyCode == KeyEvent.KEYCODE_BACK && wbWebView.canGoBack()) { // 表示按返回键
//                            wbWebView.goBack(); // 后退
//                            return true; // 已处理
//                        }
//                    }
//                    return false;
//                }
//            });

        }

        private class MyWebViewClient extends WebViewClient {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return super.shouldOverrideKeyEvent(view, event);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                // TODO Auto-generated method stub
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

        }

        private class MyWebChromeClient extends WebChromeClient {
            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     JsResult result) {
                result.confirm();
                result.cancel();
//                if (!TextUtils.isEmpty(message)) {
//                    titleView.setTitleText(message);
//                }
                return true;

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                if (!TextUtils.isEmpty(title)) {
//                    titleView.setTitleText(title);
//                }
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
//                pbLoadProgress.setProgress(newProgress);
            }
        }

        @Override
        protected void onResume() {
            super.onResume();
        }

        @Override
        protected void onPause() {
            super.onPause();


    }


}
