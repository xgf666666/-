package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Customer
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.AllOrderAdapter
import com.microple.jademall.ui.Personal.adapter.CustomerAdapter
import com.microple.jademall.ui.Personal.mvp.contract.CustomerOrderContract
import com.microple.jademall.ui.Personal.mvp.presenter.CustomerOrderPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_customer_order.*
import kotlinx.android.synthetic.main.item_title.*

/**
* author: xiaoguagnfei
* date: 2018/8/13
* describe:售后订单
*/

class CustomerOrderActivity : BaseMvpActivity<CustomerOrderPresenter>(),CustomerOrderContract.View {
    override fun getCustomer(customer: Customer) {
        loading.visibility= View.GONE
        adapter.setNewData(customer.returns)
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): CustomerOrderPresenter = CustomerOrderPresenter()
    var adapter = CustomerAdapter(arrayListOf())
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_customer_order

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="售后订单"
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            CusetomerOrderDetailActivity.startCusetomerOrderDetailActivity(this,""+(adapter as CustomerAdapter).data[position].as_id)
        }
    }

    override fun onResume() {
        super.onResume()
        getPresenter().getCustomer(Constants.getToken())
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }

    companion object {
        fun startCustomerOrderActivity(context: Context){
            val intent = Intent(context,CustomerOrderActivity::class.java)
            context.startActivity(intent)
        }
    }

}
