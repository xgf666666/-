package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.NickNameContract
import com.microple.jademall.ui.Personal.mvp.presenter.NickNamePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_nick_name.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:修改昵称
 */
class NickNameActivity : BaseMvpActivity<NickNamePresenter>(),NickNameContract.View {
    override fun setNickName() {
        var person=Constants.getPersonal()
        person.user_name=et_name.text.toString()
        Constants.putPersonal(person)
        dismissLoadingDialog()
        finish()
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): NickNamePresenter = NickNamePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_nick_name

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="个人资料设置"
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_submint.setOnClickListener{
            showLoadingDialog()
            getPresenter().setNickName(Constants.getToken(),et_name.text.toString())
        }
        iv_back.setOnClickListener{
            finish()
        }
    }

    companion object {
        fun startNickNameActivity(context: Context){
            val intent = Intent(context, NickNameActivity::class.java)
            context.startActivity(intent)
        }
    }

}
