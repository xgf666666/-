package com.microple.jademall.ui.Personal.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.google.gson.Gson
import com.microple.jademall.R
import com.microple.jademall.bean.MyMessage
import com.microple.jademall.bean.Pay
import com.microple.jademall.bean.PayTyle
import com.microple.jademall.common.Constants
import com.microple.jademall.dialog.PayDialog
import com.microple.jademall.ui.Personal.mvp.contract.OtherPayContract
import com.microple.jademall.ui.Personal.mvp.presenter.OtherPayPresenter
import com.microple.jademall.uitls.loadImag
import com.microple.jademall.weight.PwdEditText
import com.weibiaogan.bangbang.common.md5Salt
import com.xx.anypay.XxAnyPay
import com.xx.anypay.XxAnyPayResultCallBack
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_other_pay.*
import kotlinx.android.synthetic.main.item_title.*
import java.util.*

class OtherPayActivity : BaseMvpActivity<OtherPayPresenter>(),OtherPayContract.View {
    override fun refecePay(msg: String) {
        showToast("拒绝成功")
        tv_content.text="已拒绝"
        tv_pay.visibility=View.GONE
        tv_refuse.visibility=View.GONE
    }

    override fun getPayTyle(payTyle: PayTyle) {
        var dialog= PayDialog(this)
        for (i in 1..4){
            if(!payTyle.pay_type.contains("${i}")){
                dialog.setGone(i)
            }
        }
        dialog.setDaifuVis()
        dialog.show()
        dialog.setOnBtnClickListener(object : PayDialog.OnBtnClickListener {
            override fun cancel(index: Int) {
                dialog.dismiss()

                when (index) {
                    1 -> {//微信支付
                        indexs = 1
                        showLoadingDialog()
                        dialog.dismiss()
                        getPresenter().otherPay(Constants.getToken(),"1",content.sb_id,content.send,content.live,content.cabinet,content.freight_pay,content.incr_type1,content.incr_type2,content.incr_type3,content.address_id,intent.getStringExtra("user_id"),"",intent.getStringExtra("msg_id"))
                    }
                    2 -> {//支付宝支付

                        indexs = 2
                        showLoadingDialog()
                        dialog.dismiss()
                        getPresenter().otherPay(Constants.getToken(),"2",content.sb_id,content.send,content.live,content.cabinet,content.freight_pay,content.incr_type1,content.incr_type2,content.incr_type3,content.address_id,intent.getStringExtra("user_id"),"",intent.getStringExtra("msg_id"))

                    }
                    3 -> {
                        indexs = 3
                        dialog.dismiss()
                        showDialogs("" + content.total_fee)


                    }

                }
            }

        })
    }

    override fun otherPay(pay: Pay) {
        dismissLoadingDialog()
        if (indexs==1||indexs==2){
            Log.i("singgg",pay.data.sign)
            XxAnyPay.intance
                    .openAnyPay(if (indexs == 1) XxAnyPay.XXPAY_WX else XxAnyPay.XXPAY_ALI,if (indexs == 1) Gson().toJson(pay.data) else pay.data.sign, object : XxAnyPayResultCallBack {
                        override fun onPayFiale(error: String) {
                            showToast(error)
                        }

                        override fun onPaySuccess() {
                            showToast("代付成功")
                            finish()
                        }
                    })

        }else if (indexs==3){
            showToast("代付成功")
            finish()
        }

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): OtherPayPresenter = OtherPayPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_other_pay

    /**
     * 初始化数据状态
     */
    lateinit var content:MyMessage.MessagesBean.MsgParamBean
    override fun initData() {
        tv_title.text="代付"
         content=Gson().fromJson(intent.getStringExtra("content"), MyMessage.MessagesBean.MsgParamBean::class.java)
        iv_head.loadImag(content.head_img)
        tv_name.text=content.user_name
        tv_message.text=intent.getStringExtra("msg_content")
        tv_price.text="￥"+content.total_fee
        XxAnyPay.intance.init(this)
        when(intent.getIntExtra("status",0)){
                1->{

                }
                2->{
                    tv_content.text="已支付"
                    tv_pay.visibility=View.GONE
                    tv_refuse.visibility=View.GONE
                }
                3->{
                    tv_content.text="已拒绝"
                    tv_pay.visibility=View.GONE
                    tv_refuse.visibility=View.GONE
                }
        }
    }

    /**
     * 初始化事件
     */
    var indexs=1//支付方式
    override fun initEvent() {
        iv_back.setOnClickListener {
            finish()
        }
        tv_pay.setOnClickListener {
            getPresenter().getPayTyle(Constants.getToken(),"1")
            }
        tv_refuse.setOnClickListener {
            getPresenter().refecePay(Constants.getToken(),intent.getStringExtra("msg_id"))
        }

    }
    //积分支付
    var password:String?=null
    var dialog:AlertDialog?=null
    fun showDialogs(total_fee:String) {
        var view = View.inflate(mContext, R.layout.view_input_pay_psw_dialog, null)
        var psw_view=view.findViewById<PwdEditText>(R.id.psw_view)
        var bt_quxiao=view.findViewById<TextView>(R.id.bt_quxiao)
        var tv_price=view.findViewById<TextView>(R.id.tv_price)

            tv_price.text=total_fee

        bt_quxiao.setOnClickListener{
            dialog!!.dismiss()
        }
        psw_view.setOnInputFinishListener{
            password=it
            dialog!!.dismiss()
            showLoadingDialog()
            getPresenter().otherPay(Constants.getToken(),"3",content.sb_id,content.send,content.live,content.cabinet,content.freight_pay,content.incr_type1,content.incr_type2,content.incr_type3,content.address_id,intent.getStringExtra("user_id"),it.md5Salt(),intent.getStringExtra("msg_id"))

        }
        dialog = AlertDialog.Builder(mContext).create()
        dialog!!.setView(view)
        dialog!!.show()
        var timer= Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                var imm: InputMethodManager =(psw_view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                if (imm!=null)
                    imm.showSoftInput(psw_view,0)
            }
        },100)
    }

    companion object {
        fun startOtherPayActivity(context: Context,content:String,user_id:String,msg_content:String,msg_id:String,status:Int){
            val intent = Intent(context,OtherPayActivity::class.java)
            intent.putExtra("content",content)
            intent.putExtra("user_id",user_id)
            intent.putExtra("msg_content",msg_content)
            intent.putExtra("msg_content",msg_content)
            intent.putExtra("msg_id",msg_id)
            intent.putExtra("status",status)
            context.startActivity(intent)
        }
    }

}
