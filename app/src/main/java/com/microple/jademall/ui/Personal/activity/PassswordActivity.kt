package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import android.text.InputType
import android.util.Log
import com.microple.jademall.R
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.PassWorkContract
import com.microple.jademall.ui.Personal.mvp.presenter.PassWorkPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_passsword.*
import kotlinx.android.synthetic.main.item_title.*
import android.text.InputFilter



/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:修改密码跟电话
 */
class PassswordActivity : BaseMvpActivity<PassWorkPresenter>(),PassWorkContract.View {
    override fun getCode() {
        dismissLoadingDialog()
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): PassWorkPresenter =PassWorkPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_passsword


    /**
     * 初始化数据状态
     */
    var flags=0//1设置登录密码2设置交易密码3修改手机号码
    override fun initData() {
        flags=intent.getIntExtra("flag",0)
        when(flags){
            1->{
                tv_title.text="设置/修改登录密码"
                et_password.inputType= InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            2->{
                tv_newpasw.text="新交易密码"
                tv_title.text="设置/修改交易密码"
                et_password.inputType=InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
                val filters = arrayOf<InputFilter>(InputFilter.LengthFilter(6))
                et_password.filters=filters
            }
            3->{
                tv_title.text="修改手机号码"
                tv_newpasw.text="新手机号码"
                et_password.hint="请输入新手机号码"
                et_password.inputType=InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_NORMAL
            }
        }

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        var token=Constants.getToken()
        Log.i("dfaffafd",token)
        var person=Constants.getPersonal()
        tv_submint.setOnClickListener{
            showLoadingDialog()
            when(flags){
                1->{
                    getPresenter().setPW(token,et_code.text.toString(),et_password.text.toString())
                }
                2->{
                    getPresenter().setPayPW(token,et_code.text.toString(),et_password.text.toString())
                }
                3->{
                    getPresenter().setPhone(token,et_code.text.toString(),et_password.text.toString())
                }
            }
        }
        tv_getcode.setOnClickListener{
            showLoadingDialog()
            mHandler.sendEmptyMessage(1)
            getPresenter().setCode(person.phone)
        }

    }

    override fun setSucceful() {
        dismissLoadingDialog()
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

    companion object {
        fun startPassswordActivity(context: Context,flag:Int){
            val intent = Intent(context, PassswordActivity::class.java)
            intent.putExtra("flag",flag)
            context.startActivity(intent)
        }
    }
}
