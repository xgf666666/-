package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.FeedBackContract
import com.microple.jademall.ui.Personal.mvp.presenter.FeedBackPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_feed_back.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:意见反馈
 */
class FeedBackActivity : BaseMvpActivity<FeedBackPresenter>() ,FeedBackContract.View{
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): FeedBackPresenter = FeedBackPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_feed_back

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="意见反馈"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        tv_sure.setOnClickListener{
            showLoadingDialog()
            getPresenter().getContent(Constants.getToken(),tv_content.text.toString())
        }
    }

    override fun getContent(msg: String) {
        showToast(msg)
        finish()
    }

    companion object {
        fun startFeedBackActivity(context: Context){
            val intent = Intent(context,FeedBackActivity::class.java)
            context.startActivity(intent)
        }
    }

}
