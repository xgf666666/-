package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import com.microple.jademall.R
import com.microple.jademall.bean.Login
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.BindPhoneContract
import com.microple.jademall.ui.Personal.mvp.presenter.BindPhonePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_bind_phone.*
import kotlinx.android.synthetic.main.item_title.*

class BindPhoneActivity : BaseMvpActivity<BindPhonePresenter>(),BindPhoneContract.View {
    private var time = 60//验证码时间
    private var mHandler : Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            time--
            if (time > 0) {
                tv_getcode.setText(time.toString() + " s")
                tv_getcode.setEnabled(false)
                sendEmptyMessageDelayed(1,1000)
            } else {
                tv_getcode.setText("重新获取")
                time = 60
                tv_getcode.setEnabled(true)
            }
        }
    }
    override fun getCode() {
        dismissLoadingDialog()
        mHandler.sendEmptyMessage(1)
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): BindPhonePresenter = BindPhonePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_bind_phone

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="绑定手机"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        tv_submint.setOnClickListener {
            showLoadingDialog()
            getPresenter().bindPhone(intent.getStringExtra("openid"),et_phone.text.toString(),et_code.text.toString(),et_code_invite.text.toString(),intent.getStringExtra("userName"),intent.getStringExtra("userImg"))
        }
        tv_getcode.setOnClickListener{
            showLoadingDialog()
            getPresenter().getCode(et_phone.text.toString())
        }
    }

    override fun bindPhone(login: Login) {
        dismissLoadingDialog()
        showToast("绑定成功")
        Constants.putInviteCode(login.code)
        Constants.putToken(login.token)
        Constants.putHeadImg(login.head_img)
        Constants.login()
        finish()
    }

    companion object {
        fun startBindPhoneActivity(context: Context,openid:String,userImg:String,userName:String){
            val intent = Intent(context, BindPhoneActivity::class.java)
            intent.putExtra("openid",openid)
            intent.putExtra("userImg",userImg)
            intent.putExtra("userName",userName)
            context.startActivity(intent)
        }
    }

}
