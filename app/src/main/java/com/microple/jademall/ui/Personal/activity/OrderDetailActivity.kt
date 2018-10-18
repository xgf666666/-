package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.OrderDetail
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.LogisticalAdapter
import com.microple.jademall.ui.Personal.mvp.contract.OrderDetailContract
import com.microple.jademall.ui.Personal.mvp.presenter.OrderDetailPresenter
import com.microple.jademall.ui.home.activity.PaySucceefulActivity
import com.microple.jademall.uitls.loadImag
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_application.*
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.item_title.*

/**
* author: xiaoguagnfei
* date: 2018/8/14
* describe:订单详情
*/
class OrderDetailActivity : BaseMvpActivity<OrderDetailPresenter>(),OrderDetailContract.View {
    override fun sureOrder() {
        dismissLoadingDialog()
        showToast("确认成功")
        finish()
    }

    override fun exitOrder() {
        dismissLoadingDialog()
        PaySucceefulActivity.startPaySucceefulActivity(this,orderDetail?.order_detail?.order_sn!!,2)
        finish()
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): OrderDetailPresenter = OrderDetailPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_order_detail

    /**
     * 初始化数据状态
     */
    var adaptr=LogisticalAdapter(arrayListOf())
    override fun initData() {
        tv_title.text="订单详情"
        Log.i("order_id",""+intent.getStringExtra("order_id"))
        getPresenter().getDetail(Constants.getToken(),intent.getStringExtra("order_id"))
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.isNestedScrollingEnabled=false
        recyclerView.adapter=adaptr
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_order.setOnClickListener{
            var index=orderDetail?.order_detail?.order_status
            if (index==2){
                showLoadingDialog()
                getPresenter().sureOrder(Constants.getToken(),intent.getStringExtra("order_id"))
            }else if (index==3){
                if (orderDetail!!.order_detail.is_refund==0) {
                    SureCustomerActivity.startCustomerActivity(this,intent.getStringExtra("order_id")
                            ,orderDetail!!.order_detail.goods_info.goods_name
                            ,orderDetail!!.order_detail.goods_info.goods_sn
                            ,orderDetail!!.order_detail.goods_info.goods_price
                            ,orderDetail!!.order_detail.goods_info.goods_img
                            ,"" + orderDetail!!.order_detail.goods_info.goods_id)
                    finish()
                }else{
                    showToast("你已申请售后")
                }
            }else{
                showLoadingDialog()
                getPresenter().exitOrder(Constants.getToken(),intent.getStringExtra("order_id"))
            }
        }
        tv_kefu.setOnClickListener{
            CustomerServiceAcitivity.startCustomerServiceAcitivity(this)
        }
        iv_back.setOnClickListener{
            finish()
        }
    }
        var orderDetail: OrderDetail?=null
    override fun getDetail(orderDetail: OrderDetail) {
        this.orderDetail=orderDetail
        loading.visibility=View.GONE
            iv_goodsImage.loadImag(orderDetail.order_detail.goods_info.goods_img)
            tv_goodsName.text=orderDetail.order_detail.goods_info.goods_name
            tv_goodsNum.text=orderDetail.order_detail.goods_info.goods_sn
            tv_goodsPrice.text=orderDetail.order_detail.goods_info.goods_price
            tv_time.text="下单时间      "+orderDetail.order_detail.add_time
            tv_number.text="产品编号      "+orderDetail.order_detail.goods_info.goods_sn
            tv_orderNumber.text="订单号          "+orderDetail.order_detail.order_sn
            tv_shopName.text="商家名称      "+orderDetail.order_detail.supplier_name
            tv_zhengce.text="享有政策      "+orderDetail.order_detail.label
            tv_pay.text="付款方式      "+orderDetail.order_detail.pay_name
            tv_shoujianname.text="收件人         "+orderDetail.order_detail.consignee
            tv_phone.text="联系电话      "+orderDetail.order_detail.mobile
            tv_address.text="收件地址      "+orderDetail.order_detail.address
            tv_wuliu.text="物流单号      "+orderDetail.order_detail.shipping_no
            tv_wuliufuwu.text="物流服务商     "+orderDetail.order_detail.shipping_name
        if (orderDetail.order_detail.pick_type==1){
            tv_pick_type.visibility=View.VISIBLE
            tv_pick_time.visibility=View.VISIBLE
            tv_pick_service.visibility=View.VISIBLE
            view_three.visibility=View.VISIBLE
            view_two.visibility=View.VISIBLE
            view_one.visibility=View.VISIBLE
            tv_pick_type.text="提货支付方式     "+orderDetail.order_detail.pick_pay_name
            tv_pick_service.text="服务费         "+orderDetail.order_detail.service_fee+"元"
            tv_pick_time.text="提货时间    "+orderDetail.order_detail.pick_time
        }
            when(orderDetail.order_detail.order_status){
                0->{
                    if (orderDetail.order_detail.pick_type==1){
                        tv_order.visibility=View.GONE
                    }
                    tv_type.text="待审核"
                    ll_wuliu.visibility=View.GONE
                }
                1->{
                    if (orderDetail.order_detail.pick_type==1){
                        tv_order.visibility=View.GONE
                    }
                    tv_type.text="待发货"
                    ll_wuliu.visibility=View.GONE
                }
                2->{
                    tv_order.text="确认收货"
                    tv_type.text="待收货"
                    tv_wuliu.text="物流单号      "+orderDetail.order_detail.shipping_no
                    tv_wuliufuwu.text="物流服务商     "+orderDetail.order_detail.shipping_name
                    if (orderDetail.order_detail.logistics.size!=0){
                        recyclerView.visibility=View.VISIBLE
                        adaptr.setNewData(orderDetail.order_detail.logistics)
                    }else{
                        recyclerView.visibility=View.GONE
                    }

                }
                3->{
                    tv_order.text="申请售后"
                    tv_type.text="已完成"
                    tv_wuliu.text="物流单号      "+orderDetail.order_detail.shipping_no
                    tv_wuliufuwu.text="物流服务商     "+orderDetail.order_detail.shipping_name
                    if (orderDetail.order_detail.logistics.size!=0){
                        recyclerView.visibility=View.VISIBLE
                        adaptr.setNewData(orderDetail.order_detail.logistics)
                    }else{
                        recyclerView.visibility=View.GONE
                    }
//                    if (orderDetail.order_detail.buy_type!=0){
//                        tv_order.visibility=View.GONE
//                    }

                }
                4->{
                    tv_order.visibility= View.GONE
                    tv_type.text="已取消"

                }


        }
    }


    companion object {
        fun startOrderDetailActivity(context: Context,order_id:String){
            val intent = Intent(context,OrderDetailActivity::class.java)
            intent.putExtra("order_id",order_id)
            context.startActivity(intent)
        }
    }
}
