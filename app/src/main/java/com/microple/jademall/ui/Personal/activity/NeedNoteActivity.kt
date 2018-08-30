package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import com.microple.jademall.ui.home.activity.PaySucceefulActivity
import kotlinx.android.synthetic.main.activity_need_note.*

class NeedNoteActivity : AppCompatActivity() {
    companion object {
        fun startNeedNoteActivity(context: Context){
            val intent = Intent(context, NeedNoteActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_need_note)
        tv_submint.setOnClickListener {
            PaySucceefulActivity.startPaySucceefulActivity(this)
        }
    }
}
