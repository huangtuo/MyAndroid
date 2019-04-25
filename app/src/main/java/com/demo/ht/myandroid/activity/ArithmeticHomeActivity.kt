package com.demo.ht.myandroid.activity

import com.demo.ht.myandroid.R
import com.demo.ht.myandroid.base.BaseActivity
import com.demo.ht.myandroid.utils.arithmetic.StringArithmetic
import kotlinx.android.synthetic.main.activity_arithmetic.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*


/**
 * Created by huangtuo on 2018/8/21.
 */
class ArithmeticHomeActivity: BaseActivity() {


    override fun getContentViewId(): Int {
        return R.layout.activity_arithmetic
    }

    override fun initBundleData() {

    }

    override fun initView() {
        arith_btn_01.onClick {
            showToast(StringArithmetic.revarsalString("hello java and kotlin", " "))

        }
        arith_btn_02.onClick {

            var nums = intArrayOf(3,5,2,4,1,3,6,8)
            showToast(Arrays.toString(StringArithmetic.oddFront(nums)))
        }
    }

    override fun initData() {

    }
}