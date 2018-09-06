package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.flyco.dialog.listener.OnOperItemClickL
import com.flyco.dialog.widget.ActionSheetDialog
import com.microple.jademall.R
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.SureCustomerContract
import com.microple.jademall.ui.Personal.mvp.presenter.SureCustomerPresenter
import com.microple.jademall.uitls.loadImag
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_customer.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:确认售后申请
 */
class SureCustomerActivity : BaseMvpActivity<SureCustomerPresenter>(),SureCustomerContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SureCustomerPresenter = SureCustomerPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_customer

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="确认售后申请"
        tv_jifen.text="返回积分         "+intent.getStringExtra("goods_price")
        tv_goodsName.text=intent.getStringExtra("goods_name")
        tv_goodsNum.text=intent.getStringExtra("goods_sn")
        tv_goodsPrice.text=intent.getStringExtra("goods_price")
        iv_goodsImage.loadImag(intent.getStringExtra("goods_img"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_submint.setOnClickListener{
            showLoadingDialog()
            getPresenter().apply(Constants.getToken()
                    ,intent.getStringExtra("order_id")
                    ,intent.getStringExtra("goods_id")
                    ,tv_reson.text.toString()
                    ,et_jifen.text.toString()
                    ,intent.getStringExtra("goods_price"))

        }
        iv_back.setOnClickListener{
            finish()
        }
        rl_reson.setOnClickListener{
            showChangeSexDialogOne()
        }
    }

    override fun apply() {
        showToast("申请成功")
        finish()
    }

    companion object {
        fun startCustomerActivity(context: Context,order_id:String,goods_name:String,goods_sn:String,goods_price:String,goods_img:String,goods_id:String){
            val intent = Intent(context,SureCustomerActivity::class.java)
            intent.putExtra("order_id",order_id)
            intent.putExtra("goods_name",goods_name)
            intent.putExtra("goods_sn",goods_sn)
            intent.putExtra("goods_price",goods_price)
            intent.putExtra("goods_img",goods_img)
            intent.putExtra("goods_id",goods_id)
            context.startActivity(intent)
        }

    }
    private fun showChangeSexDialogOne() {
        val items=Array<String>(2,{"颜色不对";"突然不想要了"})

        val dialog = ActionSheetDialog(mContext, items, null).isTitleShow(false)
        dialog.setOnOperItemClickL(object : OnOperItemClickL {
            override fun onOperItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tv_reson.text=items[position]
                dialog.dismiss()
            }
        })
        dialog.show()
    }

}
