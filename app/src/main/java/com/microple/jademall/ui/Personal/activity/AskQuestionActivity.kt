package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.AskQuestionAdapter
import com.microple.jademall.ui.Personal.adapter.EmeraldsDetailAdapter
import kotlinx.android.synthetic.main.activity_ask_question.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:常见问题
 */
class AskQuestionActivity : AppCompatActivity() {
    companion object {
        fun startAskQuestionActivity(context: Context){
            val intent = Intent(context,AskQuestionActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask_question)
        tv_title.text="常见问题"
        var adapter= AskQuestionAdapter(arrayListOf())
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
                AskQuestionDetailActivity.startAskQuestionDetailActivity(this)
        }
    }
}
