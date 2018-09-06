package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.microple.jademall.R
import com.microple.jademall.bean.Order
import com.microple.jademall.ui.Personal.adapter.ViewPagerAdapter
import com.microple.jademall.ui.Personal.fragment.AllOrderFramgent
import com.microple.jademall.ui.Personal.mvp.contract.AllOrderContract
import com.microple.jademall.ui.Personal.mvp.presenter.AllOrderPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_all_order.*
import kotlinx.android.synthetic.main.item_title.*

/**
* author: xiaoguagnfei
* date: 2018/8/13
* describe:我的订单
*/
class AllOrderActivity : BaseMvpActivity<AllOrderPresenter>(),AllOrderContract.View {

    override fun getOrder(order: Order) {

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): AllOrderPresenter = AllOrderPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_all_order

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="我的订单"
        var data = arrayListOf("全部订单", "待审核订单", "待发货订单", "待收货订单", "已完成订单", "已取消订单")
        var fragmentManager: FragmentManager =supportFragmentManager
        var fragmentList=ArrayList<Fragment>()
        for (i in 0..data.size-1){
            var fragment=AllOrderFramgent()
            var bundle=Bundle()
            bundle.putInt("index",i)
            fragment.arguments=bundle
            fragmentList.add(fragment)
        }

        var adapter=ViewPagerAdapter(fragmentManager,fragmentList,data)
        viewPager.adapter=adapter
        tablayout.setupWithViewPager(viewPager)
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE)
        var index=intent.getIntExtra("index",1)
        viewPager.setCurrentItem(index)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
    }

    companion object {
        fun startAllOrderActivity(context: Context,index:Int){
            val intent = Intent(context,AllOrderActivity::class.java)
            intent.putExtra("index",index)
            context.startActivity(intent)
        }
    }
}
