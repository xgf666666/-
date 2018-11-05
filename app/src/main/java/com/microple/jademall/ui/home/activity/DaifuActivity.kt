package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.home.mvp.contract.DaifuContract
import com.microple.jademall.ui.home.mvp.presenter.DaifuPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_daifu.*
import kotlinx.android.synthetic.main.item_title.*

class DaifuActivity : BaseMvpActivity<DaifuPresenter>(),DaifuContract.View {
    override fun daifu() {
        showToast("代付请求发送成功！")
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): DaifuPresenter= DaifuPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_daifu

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="他人代付"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
        tv_sure.setOnClickListener {
            if (et_zhanhao.text.isNullOrEmpty()){
                showToast("请输入对方账号")
                return@setOnClickListener
            }
            if (tv_message.text.isNullOrEmpty()){
                showToast("请输入代付消息")
                return@setOnClickListener
            }
            getPresenter().daifu(Constants.getToken(),intent.getStringExtra("sb_id"),intent.getStringExtra("send"),
                    intent.getStringExtra("freight_pay"),intent.getStringExtra("live"),intent.getStringExtra("cabinet"),
                    intent.getStringExtra("incr_type1"),intent.getStringExtra("incr_type2"),intent.getStringExtra("incr_type3"),
                    intent.getStringExtra("address_id"),et_zhanhao.text.toString(),tv_message.text.toString())
        }
    }
    companion object {
        fun startDaifuActivity(context: Context, sb_id:String, send:String,freight_pay:String,live:String,cabinet:String,incr_type1:String,incr_type2:String,incr_type3:String,address_id:String){
            val intent = Intent(context, DaifuActivity::class.java)
            intent.putExtra("sb_id",sb_id)
            intent.putExtra("send",send)
            intent.putExtra("freight_pay",freight_pay)
            intent.putExtra("live",live)
            intent.putExtra("cabinet",cabinet)
            intent.putExtra("incr_type1",incr_type1)
            intent.putExtra("incr_type2",incr_type2)
            intent.putExtra("incr_type3",incr_type3)
            intent.putExtra("address_id",address_id)
            context.startActivity(intent)
        }
    }


}
