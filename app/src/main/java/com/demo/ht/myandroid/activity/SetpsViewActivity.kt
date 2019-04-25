package com.demo.ht.myandroid.activity

import com.demo.ht.myandroid.R
import com.demo.ht.myandroid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_setps_view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import com.demo.ht.myandroid.widget.StepsView.StepBean



/**
 * Created by huangtuo on 2018/8/24.
 */
class SetpsViewActivity: BaseActivity() {

    private val mStepBeans = mutableListOf<StepBean>()

    override fun getContentViewId(): Int {
        return R.layout.activity_setps_view
    }

    override fun initBundleData() {
    }

    override fun initView() {

        tv_sign_click.onClick {
            step_view.startSignAnimation(2)
        }
    }

    override fun initData() {
        mStepBeans.add(StepBean(StepBean.STEP_COMPLETED, 2))
        mStepBeans.add(StepBean(StepBean.STEP_COMPLETED, 4))
        mStepBeans.add(StepBean(StepBean.STEP_CURRENT, 10))
        mStepBeans.add(StepBean(StepBean.STEP_UNDO, 2))
        mStepBeans.add(StepBean(StepBean.STEP_UNDO, 4))
        mStepBeans.add(StepBean(StepBean.STEP_UNDO, 4))
        mStepBeans.add(StepBean(StepBean.STEP_UNDO, 30))

        step_view.setStepNum(mStepBeans)
    }
}