package com.demo.ht.myandroid.base;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import com.demo.ht.myandroid.listener.LifeCycleListener;
import com.demo.ht.myandroid.manager.ActivityStackManager;
import com.demo.ht.myandroid.utils.SPUtils;
import com.demo.ht.myandroid.widget.LoadingDialog;
import com.demo.ht.myandroid.widget.NoButShow3SDialog;
import com.demo.ht.myandroid.widget.OneButtonDialog;
import com.demo.ht.myandroid.widget.SystemBarTintManager;
import com.demo.ht.myandroid.widget.TwoButtonDialog;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.Unbinder;



/**
 * 基类Activity
 * 备注:所有的Activity都继承自此Activity
 * 1.规范团队开发
 * 2.统一处理Activity所需配置,初始化
 *
 * @author ZhongDaFeng
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    protected Context mContext;
    protected Unbinder unBinder;
    public LifeCycleListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mListener != null) {
            mListener.onCreate(savedInstanceState);
        }
        ActivityStackManager.getManager().push(this);
        setContentView(getContentViewId());
        mContext = this;
        unBinder = ButterKnife.bind(this);
        initBundleData();
        initView();
        initData();
    }

    protected void initSystemBar(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager mTintManager = new SystemBarTintManager(this);
        mTintManager.setStatusBarTintEnabled(true);
        mTintManager.setNavigationBarTintEnabled(true);
        mTintManager.setTintColor(getResources().getColor(color));
//        mTintManager.setStatusBarTintResource(color);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mListener != null) {
            mListener.onStart();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mListener != null) {
            mListener.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mListener != null) {
            mListener.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mListener != null) {
            mListener.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mListener != null) {
            mListener.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mListener != null) {
            mListener.onDestroy();
        }
        //移除view绑定
        if (unBinder != null) {
            unBinder.unbind();
        }
        ActivityStackManager.getManager().remove(this);
    }


    /**
     * 获取显示view的xml文件ID
     */
    protected abstract int getContentViewId();


    /**
     * 获取上一个界面传送过来的数据
     */
    protected abstract void initBundleData();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化Data
     */
    protected abstract void initData();

    /**
     * 设置生命周期回调函数
     *
     * @param listener
     */
    public void setOnLifeCycleListener(LifeCycleListener listener) {
        mListener = listener;
    }


    protected void showToast(String toastMsg) {
        if (!isFinishing()) {
            NoButShow3SDialog.showToast(this, toastMsg);
        }
    }

    protected void showToastFinish(String toastMsg, NoButShow3SDialog.OnDismissFinishListener onDismissFinishListener) {
        if (!isFinishing()) {
            NoButShow3SDialog.showToast(this, toastMsg, onDismissFinishListener);
        }
    }

    protected void showOneButDialog(String text, String butStr, OneButtonDialog.OnSureButtonClickListener onSureButtonClickListener) {
        if (!isFinishing()) {
            OneButtonDialog.showDialog(mContext, text, butStr, onSureButtonClickListener);
        }
    }

//    protected void showOneButDialog(String text, String butStr, String title, OneButtonDialog.OnSureButtonClickListener onSureButtonClickListener) {
//        if (!isFinishing()) {
//            OneButtonDialog.showDialog(context, text, butStr, title, onSureButtonClickListener);
//        }
//    }

    protected void showTwoButDialog(String text, String butStr, String cancleStr, TwoButtonDialog.OnSureButtonClickListener onSureButtonClickListener, TwoButtonDialog.OnCancleButtonClickListener onCancleButtonClickListener) {
        if (!isFinishing()) {
            TwoButtonDialog.showDialog(mContext, text, butStr, cancleStr, onSureButtonClickListener, onCancleButtonClickListener);
        }
    }

    /**
     * loading 运行返回键消失
     */
    protected void showLoding() {
        showLoding(true);
    }

    /**
     * @param isAllowBack 是否点击返回键，让消失
     */
    protected void showLoding(boolean isAllowBack) {
        if (!isFinishing()) {
            LoadingDialog.showDialog(this, isAllowBack, "加载中...");
        }
    }

    protected void disLoding() {
        if (!isFinishing()) {
            LoadingDialog.disDialog();
        }
    }

    protected boolean isLogin() {

        return true;
    }


}
