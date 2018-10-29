package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import cn.jpush.android.api.JPushInterface
import com.microple.jademall.MainActivity
import com.microple.jademall.R
import com.microple.jademall.bean.Login
import com.microple.jademall.bean.PersonInfo
import com.microple.jademall.common.App
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.LoginContract
import com.microple.jademall.ui.Personal.mvp.presenter.LoginPresenter
import com.microple.jademall.uitls.loadHeadImag
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.bean.SHARE_MEDIA
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:登录
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(),LoginContract.View {
    override fun threeFaid() {
        BindPhoneActivity.startBindPhoneActivity(this,mOpenId,userImg,userName)
        finish()
    }
    override fun getInfo(personalInfo: PersonInfo) {
        Constants.putPersonal(personalInfo.info)
        Constants.putHeadImg(personalInfo.info.head_img)
        dismissLoadingDialog()
        showToast("登录成功")
        Constants.login()
        Log.i("user_id","user_id"+personalInfo.info.user_id)
        JPushInterface.setAlias(this,1,""+personalInfo.info.user_id)
        finish()
    }

    override fun getCode() {
        showToast("发送成功")
        mHandler.sendEmptyMessage(1)
    }
    override fun loginSucceful(login: Login) {
        Constants.putToken(login.token)
        Constants.putHeadImg(login.head_img)
        Constants.putImIndent(login.im_identifier)
        Constants.putImuser(login.im_user_sig)
        getPresenter().getInfo(login.token)
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
            tv_right.visibility=View.GONE
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
            tv_right.visibility=View.VISIBLE
        }
        tv_regster.setOnClickListener {
            RegisterActivity.startRegisterActivity(this)
        }
        tv_wx_login.setOnClickListener {
            showLoadingDialog()
            UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener)

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
    var mOpenId = ""
    var userImg=""
    var userName=""
    var authListener: UMAuthListener = object : UMAuthListener {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        override fun onStart(platform: SHARE_MEDIA) {
            //Toast.makeText(mContext, "开始", Toast.LENGTH_LONG).show()
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        override fun onComplete(platform: SHARE_MEDIA, action: Int, data: Map<String, String>) {
//            Toast.makeText(mContext, "成功了", Toast.LENGTH_LONG).show()
            dismissLoadingDialog()
            mOpenId = data["openid"]!!
            userImg=data["profile_image_url"]!!
            userName=data["name"]!!
            Log.i("mOpenId",mOpenId)
            Log.i("userImg",userImg)
            Log.i("userName",userName)
            UMShareAPI.get(mContext).deleteOauth(this@LoginActivity,platform,null)
             getPresenter().threeLogin(mOpenId)
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        override fun onError(platform: SHARE_MEDIA, action: Int, t: Throwable) {
            dismissLoadingDialog()
            Toast.makeText(mContext, "失败：" + t.message, Toast.LENGTH_LONG).show()
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
            dismissLoadingDialog()
            Toast.makeText(mContext, "取消了", Toast.LENGTH_LONG).show()
        }
    }


    companion object {
        fun startLoginActivity(context: Context){
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
    }

}
