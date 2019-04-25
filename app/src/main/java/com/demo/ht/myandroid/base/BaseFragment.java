package com.demo.ht.myandroid.base;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.ht.myandroid.listener.LifeCycleListener;
import com.demo.ht.myandroid.widget.LoadingDialog;
import com.demo.ht.myandroid.widget.NoButShow3SDialog;
import com.demo.ht.myandroid.widget.OneButtonDialog;
import com.demo.ht.myandroid.widget.TwoButtonDialog;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 基类Fragment
 * 备注:所有的Fragment都继承自此Fragment
 * 1.规范团队开发
 * 2.统一处理Fragment所需配置,初始化
 *
 * @author ZhongDaFeng
 */
public abstract class BaseFragment extends RxFragment{

    protected Context mContext;
    protected Unbinder unBinder;
    protected View mView;
    public LifeCycleListener mListener;
    public Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
        if (mListener != null) {
            mListener.onAttach(activity);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mListener != null) {
            mListener.onCreate(savedInstanceState);
        }
        mContext = getActivity();
        if (mContext == null) return;
        mView = getContentView();
        unBinder = ButterKnife.bind(this, mView);
        initBundleData();
        initView();
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mListener != null) {
            mListener.onCreateView(inflater, container, savedInstanceState);
        }
        if (mView.getParent() != null) {
            ((ViewGroup) mView.getParent()).removeView(mView);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mListener != null) {
            mListener.onActivityCreated(savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mListener != null) {
            mListener.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mListener != null) {
            mListener.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (mListener != null) {
            mListener.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mListener != null) {
            mListener.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mListener != null) {
            mListener.onDestroyView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mListener != null) {
            mListener.onDestroy();
        }
        //移除view绑定
        if (unBinder != null) {
            unBinder.unbind();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mListener != null) {
            mListener.onDetach();
        }
    }

    /**
     * 是否已经创建
     *
     * @return
     */
    public boolean isCreated() {
        return mView != null;
    }

    /**
     * 获取显示view
     */
    protected abstract View getContentView();

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

    protected void showOneButDialog(String text, String butStr, OneButtonDialog.OnSureButtonClickListener onSureButtonClickListener) {
        if (isResumed()) {
            OneButtonDialog.showDialog(mContext, text, butStr, onSureButtonClickListener);
        }
    }

    protected void showTwoButDialog(String text, String butStr, String cancleStr, TwoButtonDialog.OnSureButtonClickListener onSureButtonClickListener, TwoButtonDialog.OnCancleButtonClickListener onCancleButtonClickListener) {
        if (isResumed()) {
            TwoButtonDialog.showDialog(mContext, text, butStr, cancleStr, onSureButtonClickListener, onCancleButtonClickListener);
        }
    }

    protected void showToast(String toastMsg) {
        if (isResumed()) {
            NoButShow3SDialog.showToast(activity, toastMsg);
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
        if (isResumed()) {
            LoadingDialog.showDialog(mContext, isAllowBack, "加载中...");
        }
    }

    protected void disLoding() {
        if (isResumed()) {
            LoadingDialog.disDialog();
        }
    }

    protected boolean isLogin() {

        return true;
    }

}
