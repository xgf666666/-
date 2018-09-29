package com.microple.jademall.ui.Personal.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import com.microple.jademall.R
import com.microple.jademall.bean.Pay
import com.microple.jademall.bean.Pick
import com.microple.jademall.common.App
import com.microple.jademall.common.Constants
import com.microple.jademall.dialog.PayDialog
import com.microple.jademall.ui.Personal.mvp.contract.PickGoodsContract
import com.microple.jademall.ui.Personal.mvp.presenter.PickGoodsPresenter
import com.microple.jademall.ui.home.activity.PaySucceefulActivity
import com.microple.jademall.weight.PwdEditText
import com.weibiaogan.bangbang.common.md5Salt
import com.xx.anypay.XxAnyPay
import com.xx.anypay.XxAnyPayResultCallBack
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_pick_goods.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:提货中心
 */
class PickGoodsActivity : BaseMvpActivity<PickGoodsPresenter>(),PickGoodsContract.View {
    override fun pay(pay: Pay) {
        if (index==1||index==2){
            Log.i("singgg",pay.data.sign)
            XxAnyPay.intance
                    .openAnyPay(if (index == 1) XxAnyPay.XXPAY_WX else XxAnyPay.XXPAY_ALI,if (index == 1) Gson().toJson(pay.data) else pay.data.sign, object : XxAnyPayResultCallBack {
                        override fun onPayFiale(error: String) {
                            showToast(error)
                        }

                        override fun onPaySuccess() {
                            showToast("支付成功")
                            PaySucceefulActivity.startPaySucceefulActivity(mContext,pay.data.order_sn)
                            finish()
                        }
                    })

        }else if (index==3){
            showToast("支付成功")
            PaySucceefulActivity.startPaySucceefulActivity(mContext,pay.data.order_sn)
            finish()
        }

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): PickGoodsPresenter = PickGoodsPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_pick_goods

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="提货"
        (application as App).addActivity(this)
        Log.i("ct_id",intent.getStringExtra("ct_id"))
        getPresenter().pick(Constants.getToken(),intent.getStringExtra("ct_id"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        rl_address.setOnClickListener{
            var intent=Intent(this,AddressActivity::class.java)
            intent.putExtra("flag",1)
            this.startActivityForResult(intent,3)
        }
        tv_pay.setOnClickListener{
            var dialog=PayDialog(this)
            dialog.show()
            dialog.setOnBtnClickListener {
                when(it){
                    1->{
                        showLoadingDialog()
                        index=1
                        getPresenter().pay(Constants.getToken(),"","","",pick?.user_address?.ua_id!!,"1","","","1",intent.getStringExtra("ct_id"))
                    }
                    2->{
                        showLoadingDialog()
                        index=2
                        getPresenter().pay(Constants.getToken(),"","","",pick?.user_address?.ua_id!!,"2","","","1",intent.getStringExtra("ct_id"))
                    }
                    3->{
                        index=3
                        showDialog()
                    }
                }
            }
        }
    }
    //支付框
    var index=0
    var dialog:AlertDialog?=null
    var password:String?=null
    fun showDialog() {
        var view = View.inflate(mContext, R.layout.view_input_pay_psw_dialog, null)

        var psw_view=view.findViewById<PwdEditText>(R.id.psw_view)
        var bt_quxiao=view.findViewById<TextView>(R.id.bt_quxiao)
        var tv_price=view.findViewById<TextView>(R.id.tv_price)
        tv_price.text=pick?.service_fee
        bt_quxiao.setOnClickListener{
            dialog!!.dismiss()
        }
        psw_view.setOnInputFinishListener{
            password=it
            showDialog()
            dialog!!.dismiss()
            getPresenter().pay(Constants.getToken(),"","","",pick?.user_address?.ua_id!!,"3",password!!.md5Salt(),"","1",intent.getStringExtra("ct_id"))

        }
        dialog = AlertDialog.Builder(mContext).create()
        dialog!!.setView(view)
        dialog!!.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        (application as App).deleteActivity(this)
    }

    override fun onResume() {
        super.onResume()
        getPresenter().pick(Constants.getToken(),intent.getStringExtra("ct_id"))
    }
    var pick: Pick?=null
    override fun pick(pick: Pick) {
        loading.visibility=View.GONE
        this.pick=pick
        if (pick.user_address==null){
            add_address.visibility=View.VISIBLE
        }else{
            add_address.visibility=View.GONE
            tv_content.text=pick.user_address.consigner+"     "+pick.user_address.phone
            tv_address.text=pick.user_address.address
        }

        tv_number.text=pick.goods_sn
        tv_stye.text=pick.type
        tv_beizhu.text=pick.remark
        tv_fuwufei.text="￥"+pick.service_fee
    }
    var name=""
    var phone=""
    var address=""
    var id=""
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==3&&resultCode==3){
            name=data?.getStringExtra("name")!!
            phone=data?.getStringExtra("phone")
            address=data?.getStringExtra("address")
            id=data?.getStringExtra("id")
            tv_content.text=name+"       "+phone
            add_address.visibility=View.GONE
            tv_content.visibility=View.VISIBLE
            tv_address.visibility=View.VISIBLE
            tv_address.text=address
            pick?.user_address?.ua_id=id
        }

    }

    companion object {
        fun startPickGoodsActivity(context: Context,ct_id:String){
            val intent = Intent(context,PickGoodsActivity::class.java)
            intent.putExtra("ct_id",ct_id)
            context.startActivity(intent)
        }
    }

}
