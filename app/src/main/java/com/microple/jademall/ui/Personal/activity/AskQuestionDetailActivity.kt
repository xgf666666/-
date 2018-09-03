package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.bean.AskDetail
import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionDetailContract
import com.microple.jademall.ui.Personal.mvp.presenter.AskQuestionDetailPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_ask_question_detail.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:常见问题详情
 */
class AskQuestionDetailActivity : BaseMvpActivity<AskQuestionDetailPresenter>(),AskQuestionDetailContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): AskQuestionDetailPresenter = AskQuestionDetailPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_ask_question_detail

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text=intent.getStringExtra("content")
        getPresenter().getDetail(intent.getStringExtra("pt_id"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{finish()}

    }

    override fun getDetail(askDetail: AskDetail) {
        loading.visibility= View.GONE
        tv_content.text=askDetail.problem.answer
    }

    companion object {
        fun startAskQuestionDetailActivity(context: Context,pt_id:String,content:String){
            val intent = Intent(context,AskQuestionDetailActivity::class.java)
            intent.putExtra("pt_id",pt_id)
            intent.putExtra("content",content)
            context.startActivity(intent)
        }
    }


}
