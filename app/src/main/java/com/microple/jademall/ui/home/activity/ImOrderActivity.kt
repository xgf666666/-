package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.dialog.BuytypeDialog
import com.microple.jademall.dialog.PayDialog
import com.microple.jademall.ui.home.adapter.ImOrderAdapter
import kotlinx.android.synthetic.main.activity_im_order.*
import kotlinx.android.synthetic.main.item_title.*
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import com.microple.jademall.bean.ImOrder
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.home.mvp.contract.ImOrderContract
import com.microple.jademall.ui.home.mvp.presenter.ImOrderPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity


/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:立即下单
 */
class ImOrderActivity : BaseMvpActivity<ImOrderPresenter>(),ImOrderContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): ImOrderPresenter = ImOrderPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_im_order

    /**
     * 初始化数据状态
     */
     var adapter=ImOrderAdapter(arrayListOf())
    var you_list= arrayListOf<String>()
    var live_list= arrayListOf<String>()
    var feicui_list= arrayListOf<String>()
    override fun initData() {
        tv_title.text="立即下单"
        getPresenter().imOrder(Constants.getToken(),intent.getStringExtra("sb_id"),intent.getStringExtra("goods_id"))
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        rv_myOrder.layoutManager= LinearLayoutManager(this)
        rv_myOrder.isNestedScrollingEnabled = false
        rv_myOrder.adapter=adapter
        adapter.setOnItemChildClickListener { adapter, view, position ->
            var goods=(adapter as ImOrderAdapter).data[position]
            if (view.id==R.id.ll_type){
                var dialog=BuytypeDialog(this)
                dialog.show()
                dialog.setOnBtnClickListener(object : BuytypeDialog.OnBtnClickListener {
                    override fun cancel(index: Int) {
                        when(index){
                            1->{
                                if (!you_list.contains(goods.goods_sn)){
                                    you_list.add(goods.goods_sn)
                                }
                                if (live_list.contains(goods.goods_sn)){
                                    live_list.remove(goods.goods_sn)
                                }else if (feicui_list.contains(goods.goods_sn)){
                                    feicui_list.remove(goods.goods_sn)
                                }
                            }
                            2->{
                                if (!live_list.contains(goods.goods_sn)){
                                    live_list.add(goods.goods_sn)
                                }
                                if (you_list.contains(goods.goods_sn)){
                                    you_list.remove(goods.goods_sn)
                                }else if (feicui_list.contains(goods.goods_sn)){
                                    feicui_list.remove(goods.goods_sn)
                                }
                            }
                            3->{
                                if (!feicui_list.contains(goods.goods_sn)){
                                    feicui_list.add(goods.goods_sn)
                                }
                                if (you_list.contains(goods.goods_sn)){
                                    you_list.remove(goods.goods_sn)
                                }else if (live_list.contains(goods.goods_sn)){
                                    live_list.remove(goods.goods_sn)
                                }
                            }
                         }
                        if (you_list.size!=0){
                            tv_youji.visibility=View.VISIBLE
                            var str=""
                            for (i in 0..you_list.size-1){
                                if (i==0)
                                    str= you_list[i]
                                else
                                    str=str+"/"+you_list[i]
                            }
                            tv_youji.text="邮寄:                "+str
                        }else{
                            tv_youji.visibility=View.GONE
                        }
                        if(live_list.size!=0){
                                tv_zhibo.visibility=View.VISIBLE
                                var str=""
                                for (i in 0..live_list.size-1){
                                    if (i==0)
                                        str= live_list[i]
                                    else
                                        str=str+"/"+live_list[i]
                                }
                                tv_zhibo.text="预约切石直播:"+str
                        }else{
                            tv_zhibo.visibility=View.GONE
                        }
                        if (feicui_list.size!=0){
                            tv_cun.visibility=View.VISIBLE
                            var str=""
                            for (i in 0..feicui_list.size-1){
                                if (i==0)
                                    str= feicui_list[i]
                                else
                                    str=str+"/"+feicui_list[i]
                            }
                            tv_cun.text="存入翡翠柜:    "+str
                        }else{
                            tv_cun.visibility=View.GONE
                        }
                        dialog.dismiss()
                    }

                })
            }
        }
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_submint.setOnClickListener{
            var dialog=PayDialog(this)
            dialog.show()
            dialog.setOnBtnClickListener(object : PayDialog.OnBtnClickListener {
                override fun cancel(index: Int) {
                    dialog.dismiss()
                    PaySucceefulActivity.startPaySucceefulActivity(application)
                }

            })
        }
        var index:Int=1
        tv_buy.setOnClickListener{
            adapter.upDateAdapter(index)
            if (index==1){
                index=0
            }else{
                index=1
            }
        }
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun imOrder(imOrder: ImOrder) {
        loading.visibility=View.GONE
        adapter.setNewData(imOrder.order.goods_info)
        tv_wuliu.text="物流费用:  ￥"+imOrder.order.shipping_fee
        tv_content.text=imOrder.order.user_address.consigner+"       "+imOrder.order.user_address.phone
        tv_address.text=imOrder.order.user_address.address
        tv_price.text="购物袋合计      ￥"+imOrder.order.total_fee
    }

    companion object {
        fun startImOrderActivity(context: Context,sb_id:String,goods_id:String){
            val intent = Intent(context, ImOrderActivity::class.java)
            intent.putExtra("sb_id",sb_id)
            intent.putExtra("goods_id",goods_id)
            context.startActivity(intent)
        }
    }

}
