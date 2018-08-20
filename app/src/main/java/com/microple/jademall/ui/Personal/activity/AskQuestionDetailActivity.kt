package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:常见问题详情
 */
class AskQuestionDetailActivity : AppCompatActivity() {
    companion object {
        fun startAskQuestionDetailActivity(context: Context){
            val intent = Intent(context,AskQuestionDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask_question_detail)
        iv_back.setOnClickListener{finish()}
    }

}
