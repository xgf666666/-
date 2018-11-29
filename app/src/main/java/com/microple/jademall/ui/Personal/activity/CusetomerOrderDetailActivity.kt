package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.bean.CustiomerDetail
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.CusetomerOrderDetailContract
import com.microple.jademall.ui.Personal.mvp.presenter.CustomerOrderDetailPresenter
import com.microple.jademall.uitls.loadImag
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_cusetomer_order_detail.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:售后订单详情
 */
class CusetomerOrderDetailActivity : BaseMvpActivity<CustomerOrderDetailPresenter>(), CusetomerOrderDetailContract.View {
    override fun sendBack() {
        dismissLoadingDialog()
        showToast("提交成功")
        finish()

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): CustomerOrderDetailPresenter = CustomerOrderDetailPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int = R.layout.activity_cusetomer_order_detail

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text = "售后订单详情"
        getPresenter().getDetail(Constants.getToken(), intent.getStringExtra("as_id"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener {
            finish()
        }
        tv_kefu.setOnClickListener {
            CustomerServiceAcitivity.startCustomerServiceAcitivity(this)
        }
        tv_baocun.setOnClickListener {
            showLoadingDialog()
            getPresenter().sendBack(Constants.getToken(), intent.getStringExtra("as_id"), et_kuaidi.text.toString(), et_number.text.toString())
        }
    }

    override fun getDetail(custiomerDetail: CustiomerDetail) {
        loading.visibility = View.GONE
        iv_goodsImage.loadImag(custiomerDetail.returns.goods_info.goods_img)
        tv_goodsName.text = custiomerDetail.returns.goods_info.goods_name
        tv_goodsNum.text = custiomerDetail.returns.goods_info.goods_sn
        tv_yuanyin.text = custiomerDetail.returns.reason
        tv_shuoming.text = custiomerDetail.returns.desc
        tv_number.text = custiomerDetail.returns.aftersales_bn
        tv_time.text = custiomerDetail.returns.add_time
        tv_jifen.text = custiomerDetail.returns.refunds_fee
        if (custiomerDetail.returns.status == 2) {
            rl_number.visibility = View.VISIBLE
            rl_kuaidi.visibility = View.VISIBLE
        }
        tv_type.text = custiomerDetail.returns.status_desc
    }

    companion object {
        fun startCusetomerOrderDetailActivity(context: Context, as_id: String) {
            val intent = Intent(context, CusetomerOrderDetailActivity::class.java)
            intent.putExtra("as_id", as_id)
            context.startActivity(intent)
        }
    }

}
