package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Ask
import com.microple.jademall.ui.Personal.adapter.AskQuestionAdapter
import com.microple.jademall.ui.Personal.adapter.EmeraldsDetailAdapter
import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionContract
import com.microple.jademall.ui.Personal.mvp.presenter.AskQuestionPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_ask_question.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:常见问题
 */
class AskQuestionActivity : BaseMvpActivity<AskQuestionPresenter>(),AskQuestionContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): AskQuestionPresenter = AskQuestionPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_ask_question

    /**
     * 初始化数据状态
     */
    var adapter= AskQuestionAdapter(arrayListOf())
    override fun initData() {
        tv_title.text="常见问题"
        getPresenter().getAsk(intent.getStringExtra("pt_id"))
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            AskQuestionDetailActivity.startAskQuestionDetailActivity(this,""+(adapter as AskQuestionAdapter).data[position].pb_id,adapter.data[position].problem)
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

    override fun getAsk(ask: Ask) {
        loading.visibility= View.GONE
        adapter.setNewData(ask.problem)
    }

    companion object {
        fun startAskQuestionActivity(context: Context,pt_id:String){
            val intent = Intent(context,AskQuestionActivity::class.java)
            intent.putExtra("pt_id",pt_id)
            context.startActivity(intent)
        }
    }

}
