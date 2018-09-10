package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.bean.Pick
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.PickGoodsContract
import com.microple.jademall.ui.Personal.mvp.presenter.PickGoodsPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_pick_goods.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:提货中心
 */
class PickGoodsActivity : BaseMvpActivity<PickGoodsPresenter>(),PickGoodsContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): PickGoodsPresenter = PickGoodsPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_pick_goods

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="提货"
        getPresenter().pick(Constants.getToken(),intent.getStringExtra("ct_id"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        rl_address.setOnClickListener{
            AddressActivity.startAddressActivity(this)
        }
        tv_pay.setOnClickListener{

        }
    }

    override fun onResume() {
        super.onResume()
        getPresenter().pick(Constants.getToken(),intent.getStringExtra("ct_id"))
    }

    override fun pick(pick: Pick) {
        loading.visibility=View.GONE
        tv_content.text=pick.user_address.consigner+"     "+pick.user_address.phone
        tv_address.text=pick.user_address.address
        tv_number.text=pick.goods_sn
        tv_stye.text=pick.type
        tv_beizhu.text=pick.remark
        tv_fuwufei.text="￥"+pick.service_fee
    }

    companion object {
        fun startPickGoodsActivity(context: Context,ct_id:String){
            val intent = Intent(context,PickGoodsActivity::class.java)
            intent.putExtra("ct_id",ct_id)
            context.startActivity(intent)
        }
    }

}
