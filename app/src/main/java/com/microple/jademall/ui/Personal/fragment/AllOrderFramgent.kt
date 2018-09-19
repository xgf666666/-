package com.microple.jademall.ui.Personal.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Order
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.activity.OrderDetailActivity
import com.microple.jademall.ui.Personal.adapter.AllOrderAdapter
import com.microple.jademall.ui.Personal.mvp.contract.AllOrderContract
import com.microple.jademall.ui.Personal.mvp.presenter.AllOrderPresenter
import com.xx.baseuilibrary.mvp.BaseMvpFragment
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_allorder.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:
 */
class AllOrderFramgent :BaseMvpFragment<AllOrderContract.Model,AllOrderContract.View,AllOrderPresenter>(),AllOrderContract.View{




    override fun getOrder(order: Order) {
        loading.visibility=View.GONE
        if (order.order_list.size==0){
            tv_tishi.visibility=View.VISIBLE
        }else{
            tv_tishi.visibility=View.GONE
            adapter.setNewData(order.order_list)
        }
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): AllOrderPresenter = AllOrderPresenter()

    var adapter = AllOrderAdapter(arrayListOf())

    /**
     * 获取Fragment的布局资源文件id
     */
    override fun getFragmentLayoutId(): Int = R.layout.fragment_allorder

    /**
     * 初始化
     */
    var index=0
    override fun init(view: View?) {
         index=arguments!!.getInt("index",0)
        when(index){
            //全部订单
            0->{
                getPresenter().getOrder(Constants.getToken(),"")
            }
           //待审核订单
            1->{
                getPresenter().getOrder(Constants.getToken(),"0")

            }
           //发货订单
            2->{
                getPresenter().getOrder(Constants.getToken(),"1")

            }
           //收货订单
            3->{
                getPresenter().getOrder(Constants.getToken(),"2")

            }
           //已完成订单
            4->{
                getPresenter().getOrder(Constants.getToken(),"3")

            }
           //已取消订单
            5->{
                getPresenter().getOrder(Constants.getToken(),"4")

            }

        }
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            OrderDetailActivity.startOrderDetailActivity(context!!,""+(adapter as AllOrderAdapter).data[position].order_id)
        }
    }

    override fun onResume() {
        super.onResume()
        if (!isHidden){
            if (index==0){
                getPresenter().getOrder(Constants.getToken(),"")
            }else{
                getPresenter().getOrder(Constants.getToken(),""+(index-1))
            }

        }
    }
}