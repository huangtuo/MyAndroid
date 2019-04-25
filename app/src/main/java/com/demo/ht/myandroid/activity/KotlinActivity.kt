package com.demo.ht.myandroid.activity

import butterknife.internal.Utils.listOf
import com.demo.ht.myandroid.R
import kotlinx.android.synthetic.main.activity_kotlin.*
import com.demo.ht.myandroid.base.BaseActivity
import org.jetbrains.anko.sdk25.coroutines.onClick


/**
 * @author huangtuo
 * @time 2017/11/13.
 */
class KotlinActivity: BaseActivity() {


    override fun getContentViewId(): Int {
        return R.layout.activity_kotlin
    }

    override fun initBundleData() {

    }

    override fun initData() {

    }



    override fun initView(){

        kotlin_btn_01.onClick {
            showToast(testStr("第一个->","第二个->", "修改第三个"))
        }
        kotlin_btn_02.onClick {
            showToast(zhankaiArray(arrayOf("c:", "d:", "e:")))
//            ToastUtil.show(this@KotlinActivity,"最后一个字符".lastChar() + "")
        }
        kotlin_btn_photo.onClick {

//            startActivity(Intent(this@KotlinActivity, PhotoWallActivity::class.java))
        }
    }

    fun testStr(str1: String, str2: String, str3: String = "初始") : String{

        return str1 + str2 + str3
    }

    fun zhankaiArray(args: Array<String>): String{
        val sun = {x: Int, y: Int -> x + y}

        val url = "http://kotlin"
        performRequest(url){
            code, content -> code.toString() + content
        }
        val list = listOf("a:", "b:", *args)
        return list.toString()
    }

    fun performRequest(url: String, callBack: (code: Int, content: String)-> Unit): Unit{
        callBack(3, "hello")
    }


}
