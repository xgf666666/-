package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.mvp.contract.ForgetPWContract
import com.microple.jademall.ui.Personal.mvp.presenter.ForgetPWPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_forget_pw.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:忘记密码
 */
class ForgetPWActivity : BaseMvpActivity<ForgetPWPresenter>(),ForgetPWContract.View {

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
    override fun createPresenter(): ForgetPWPresenter = ForgetPWPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_forget_pw

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="忘记密码"
        view_l.visibility= View.GONE
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_submint.setOnClickListener{
            showLoadingDialog()
            getPresenter().setPW(et_phone.text.toString(),et_code.text.toString(),et_password.text.toString())
        }
        tv_getcode.setOnClickListener{
            showLoadingDialog()
            getPresenter().getCode(et_phone.text.toString())
        }
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun setPW() {
        dismissLoadingDialog()
        finish()
    }

    override fun getCode() {
        dismissLoadingDialog()
        mHandler.sendEmptyMessage(1)

    }

    companion object {
        fun startForgetPWActivity(context: Context){
            val intent = Intent(context, ForgetPWActivity::class.java)
            context.startActivity(intent)
        }
    }

}
