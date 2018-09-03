package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.microple.jademall.MainActivity
import com.microple.jademall.R
import com.microple.jademall.bean.Login
import com.microple.jademall.common.App
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.LoginContract
import com.microple.jademall.ui.Personal.mvp.presenter.LoginPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:登录
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(),LoginContract.View {
    override fun getCode() {
        showToast("发送成功")
        mHandler.sendEmptyMessage(1)
    }
    override fun loginSucceful(login: Login) {
//        (application as App).cleanActivity()
//        MainActivity.startMainActivity(this)
        dismissLoadingDialog()
        showToast("登录成功")
        Constants.putInviteCode(login.code)
        Constants.putToken(login.token)
        Constants.login()
        finish()

    }

    var index=1
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

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): LoginPresenter = LoginPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_login

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.visibility= View.GONE
        tv_right.visibility=View.VISIBLE
        view_l.visibility=View.GONE
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_right.setOnClickListener{
            ForgetPWActivity.startForgetPWActivity(this)
        }
        iv_back.setOnClickListener{
            finish()
        }
        tv_kuai.setOnClickListener{
            index=1
            tv_kuai.setTextSize(17f)
            tv_kuai.setTextColor(resources.getColor(R.color.black_333333))
            tv_paswork.setTextColor(resources.getColor(R.color.green_06A366))
            tv_paswork.setTextSize(14f)
            tv_getcode.visibility=View.VISIBLE
            et_code.hint="请输入验证码"
            et_code.inputType=InputType.TYPE_CLASS_NUMBER
            et_code.setText("")
            et_code.inputType=InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_NORMAL

        }
        tv_paswork.setOnClickListener{
            index=2
            tv_kuai.setTextSize(14f)
            tv_kuai.setTextColor(resources.getColor(R.color.green_06A366))
            tv_paswork.setTextColor(resources.getColor(R.color.black_333333))
            tv_paswork.setTextSize(17f)
            tv_getcode.visibility=View.GONE
            et_code.hint="密码"
            et_code.setText("")
            et_code.inputType=InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        }
        tv_regster.setOnClickListener {
            RegisterActivity.startRegisterActivity(this)
        }
        tv_wx_login.setOnClickListener {
            BindPhoneActivity.startBindPhoneActivity(this)
        }
        tv_getcode.setOnClickListener{
            getPresenter().getCode(et_phone.text.toString())
        }
        tv_submint.setOnClickListener{
            showLoadingDialog()
            if (index==1){
                getPresenter().codeLogin(et_phone.text.toString(),et_code.text.toString())
            }else if (index==2){
                getPresenter().pwLogin(et_phone.text.toString(),et_code.text.toString())
            }
        }
    }

    companion object {
        fun startLoginActivity(context: Context){
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

}
