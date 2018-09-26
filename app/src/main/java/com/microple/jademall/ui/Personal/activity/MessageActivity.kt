package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.MyMessage
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.BillQueryAdapter
import com.microple.jademall.ui.Personal.adapter.MessageAdapter
import com.microple.jademall.ui.Personal.mvp.contract.MessageContract
import com.microple.jademall.ui.Personal.mvp.presenter.MessagePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_message.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:消息列表 */
class MessageActivity : BaseMvpActivity<MessagePresenter>(),MessageContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): MessagePresenter = MessagePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_message

    /**
     * 初始化数据状态
     */
    var adapter= MessageAdapter(arrayListOf())
    override fun initData() {
        tv_title.text="消息列表"
        getPresenter().getMessage(Constants.getToken())
//        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
//        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            MessageDetailActivity.startMessageDetailActivity(this,""+(adapter as MessageAdapter).data[position].msg_id)
        }
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun getMessage(myMessage: MyMessage) {
        loading.visibility= View.GONE
        if (myMessage.messages.size==0){
            tv_tishi.visibility=View.VISIBLE
        }
        adapter.setNewData(myMessage.messages)
    }

    companion object {
        fun startMessageActivity(context: Context){
            val intent = Intent(context,MessageActivity::class.java)
            context.startActivity(intent)
        }
    }

}
