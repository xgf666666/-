package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.AskType
import com.microple.jademall.ui.Personal.adapter.AskQuestionAdapter
import com.microple.jademall.ui.Personal.adapter.AskQuestionTypeAdapter
import com.microple.jademall.ui.Personal.adapter.EmeraldsDetailAdapter
import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionTypeContract
import com.microple.jademall.ui.Personal.mvp.presenter.AskQuestionTypePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_ask_question.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:常见问题
 */
class AskQuestionTypeActivity : BaseMvpActivity<AskQuestionTypePresenter>(),AskQuestionTypeContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): AskQuestionTypePresenter = AskQuestionTypePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_ask_question

    /**
     * 初始化数据状态
     */
    var adapter= AskQuestionTypeAdapter(arrayListOf())
    override fun initData() {
        tv_title.text="常见问题"
        getPresenter().getType()
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            AskQuestionActivity.startAskQuestionActivity(this,""+(adapter as AskQuestionTypeAdapter).data[position].pt_id)
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

    override fun getType(askType: AskType) {
        loading.visibility= View.GONE
        adapter.setNewData(askType.problem_type)
    }

    companion object {
        fun startAskQuestionTypeActivity(context: Context){
            val intent = Intent(context,AskQuestionTypeActivity::class.java)
            context.startActivity(intent)
        }
    }

}
