package com.demo.ht.myandroid.activity

import android.os.Build
import android.support.v7.app.ActionBar
import android.view.View
import com.demo.ht.myandroid.R
import com.demo.ht.myandroid.base.BaseActivity


class FullScreenActivity : BaseActivity() {
    override fun getContentViewId(): Int {
        return R.layout.activity_full_screen
    }

    override fun initBundleData() {

    }

    override fun initView() {
        if(Build.VERSION.SDK_INT >= 21){
            var decorView: View = window.decorView
            /**
            SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE注意两个Flag必须要结合在一起使用，
            表示会让应用的主体内容占用系统状态栏的空间，
            最后再调用Window的setStatusBarColor()方法将状态栏设置成透明色就可以了。
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
             */
            /**
             * 隐藏状态栏
             *View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
             * window.navigationBarColor = Color.TRANSPARENT  设置透明 否则直接隐藏
             */
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN

        }

        var actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }

    override fun initData() {

    }



}
