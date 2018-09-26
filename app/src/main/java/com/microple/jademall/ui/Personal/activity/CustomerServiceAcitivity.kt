package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import com.microple.jademall.bean.ServicePhone
import com.microple.jademall.ui.Personal.mvp.contract.CustomerServiceContract
import com.microple.jademall.ui.Personal.mvp.presenter.CustomerServicePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_customer_service_acitivity.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:联系客服
 */
class CustomerServiceAcitivity : BaseMvpActivity<CustomerServicePresenter>(),CustomerServiceContract.View {
    var phone=""
    override fun getPhone(servicePhone: ServicePhone) {
        phone=servicePhone.service_phone
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): CustomerServicePresenter =CustomerServicePresenter()

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_customer_service_acitivity

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="联系客服"
        getPresenter().getphone()
        tv_phone.setOnClickListener{
            val uri = Uri.parse("tel:"+phone)
            val it = Intent(Intent.ACTION_DIAL, uri)
            startActivity(it)
        }
        iv_back.setOnClickListener{
            finish()
        }
        tv_line.setOnClickListener {
            showToast("暂未开放，敬请期待")
        }
    }

    companion object {
        fun startCustomerServiceAcitivity(context: Context){
            val intent = Intent(context,CustomerServiceAcitivity::class.java)
            context.startActivity(intent)
        }
    }

}
