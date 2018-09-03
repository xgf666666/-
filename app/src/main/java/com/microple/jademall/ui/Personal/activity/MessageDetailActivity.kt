package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.bean.MessageDetail
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.MessageDetailContract
import com.microple.jademall.ui.Personal.mvp.presenter.MessageDetailPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_message_detail.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:消息详情
 */
class MessageDetailActivity : BaseMvpActivity<MessageDetailPresenter>(),MessageDetailContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): MessageDetailPresenter = MessageDetailPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_message_detail

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="消息详情"
        getPresenter().getMessageDetail(Constants.getToken(),intent.getStringExtra("msg_id"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun getMessageDetail(messageDetail: MessageDetail) {
        loading.visibility= View.GONE
        tv_content.text=messageDetail.msg_detail.msg_content
    }

    companion object {
        fun startMessageDetailActivity(context: Context,msg_id:String){
            val intent = Intent(context,MessageDetailActivity::class.java)
            intent.putExtra("msg_id",msg_id)
            context.startActivity(intent)
        }
    }

}
