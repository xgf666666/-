package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import com.microple.jademall.R
import com.microple.jademall.bean.AboutMe
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.presenter.AboutMePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_about_me.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:关于我们
 */
class AboutMeActivity : BaseMvpActivity<AboutMePresenter>(),AboutMeContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): AboutMePresenter = AboutMePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_about_me

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="关于我们"
        showLoadingDialog()
        getPresenter().aboutMe()
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }

    }

    override fun aboutMe(aboutMe: AboutMe) {
        dismissLoadingDialog()
        wv_content.loadDataWithBaseURL(null,aboutMe.about_us,"text/html","utf-8",null)
    }

    companion object {
        fun startAboutMeActivity(context: Context){
            val intent = Intent(context,AboutMeActivity::class.java)
            context.startActivity(intent)
        }
    }

}
