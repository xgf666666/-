package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.mvp.contract.RegisterContract
import com.microple.jademall.ui.Personal.mvp.presenter.RegisterPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:注册页面
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterContract.View {
    override fun getCode(code: String) {
        mHandler.sendEmptyMessage(1)
        dismissLoadingDialog()

    }

    override fun register() {
        dismissLoadingDialog()
        showToast("注册成功")
        finish()
    }

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
    override fun createPresenter(): RegisterPresenter = RegisterPresenter()
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_register

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="注册"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_getcode.setOnClickListener {
            showLoadingDialog()
                getPresenter().getCode(et_phone.text.toString())
        }
        tv_submint.setOnClickListener{
            showLoadingDialog()
            getPresenter().register(et_phone.text.toString(),et_code.text.toString(),et_password.text.toString(),et_sure_password.text.toString(),et_code_invite.text.toString())
        }
        iv_back.setOnClickListener{
            finish()
        }
    }

    companion object {
        fun startRegisterActivity(context: Context){
            val intent = Intent(context, RegisterActivity::class.java)
            context.startActivity(intent)
        }
    }
}
