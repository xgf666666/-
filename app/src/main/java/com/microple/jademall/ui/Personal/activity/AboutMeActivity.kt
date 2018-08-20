package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_about_me.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:关于我们
 */
class AboutMeActivity : AppCompatActivity() {
    companion object {
        fun startAboutMeActivity(context: Context){
            val intent = Intent(context,AboutMeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        tv_title.text="关于我们"
        var code=this.packageManager.getPackageInfo(this.packageName,0).versionCode
        tv_code.text="版本号:"+code
    }
}
