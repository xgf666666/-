package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.MyAppointment
import com.microple.jademall.common.App
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.MyAppointmentAdapter
import com.microple.jademall.ui.Personal.adapter.MyAppointmentTwoAdapter
import com.microple.jademall.ui.Personal.mvp.contract.MyAppointmentContract
import com.microple.jademall.ui.Personal.mvp.presenter.MyAppointmentPresenter
import com.microple.jademall.ui.live.activity.LiveDetailsActivity
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_my_appointment.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:我的预约
 */
class MyAppointmentActivity : BaseMvpActivity<MyAppointmentPresenter>(),MyAppointmentContract.View {
    override fun exitAppoint(msg: String) {
        showToast(msg)
        getPresenter().myAppoint(Constants.getToken())
    }

    var adapterOne=MyAppointmentAdapter(arrayListOf())
    var adapterTwo=MyAppointmentTwoAdapter(arrayListOf())
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): MyAppointmentPresenter = MyAppointmentPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_my_appointment

    override fun onDestroy() {
        super.onDestroy()
        (application as App).deleteActivity(this)
    }

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.setText("我的预约")
        (application as App).addActivity(this)
        getPresenter().myAppoint(Constants.getToken())
        adapterOne.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView_one.layoutManager= LinearLayoutManager(this)
        recyclerView_one.adapter=adapterOne
        adapterOne.setOnItemClickListener { adapter, view, position ->
            LiveDetailsActivity.startLiveDetail(this,(adapter as MyAppointmentAdapter).data[position].live_id)
        }
        adapterOne.setOnItemChildClickListener { adapter, view, position ->
            getPresenter().exitAppoint(Constants.getToken(),(adapter as MyAppointmentAdapter).data[position].live_id)
            adapterOne.remove(position)
        }
        adapterTwo.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView_two.layoutManager=LinearLayoutManager(this)
        recyclerView_two.adapter=adapterTwo
        adapterTwo.setOnItemClickListener { adapter, view, position ->
            LiveDetailsActivity.startLiveDetail(this,(adapter as MyAppointmentTwoAdapter).data[position].live_id)
        }
        adapterTwo.setOnItemChildClickListener { adapter, view, position ->
            getPresenter().exitAppoint(Constants.getToken(),(adapter as MyAppointmentTwoAdapter).data[position].live_id)
            adapterTwo.remove(position)
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

    override fun myAppoint(myAppointment: MyAppointment) {
        loading.visibility=View.GONE
        if (myAppointment.recent_appoint.size==0){
            tv_tishiOne.visibility=View.VISIBLE
        }
        if (myAppointment.all_appoint.size==0){
            tv_tishitwo.visibility=View.VISIBLE
        }
        if (myAppointment.recent_appoint.size==0&&myAppointment.all_appoint.size==0){
            tv_tishi.visibility=View.VISIBLE
            tv_tishitwo.visibility=View.GONE
            tv_tishiOne.visibility=View.GONE
        }else{
            tv_tishi.visibility=View.GONE
        }
        adapterOne.setNewData(myAppointment.recent_appoint)
        adapterTwo.setNewData(myAppointment.all_appoint)
    }

    companion object {
        fun startMyAppointmentActivity(context: Context){
            val intent = Intent(context,MyAppointmentActivity::class.java)
            context.startActivity(intent)
        }
    }

}
