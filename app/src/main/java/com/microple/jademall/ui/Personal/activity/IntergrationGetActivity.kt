package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Profit
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.EmeraldsDetailAdapter
import com.microple.jademall.ui.Personal.mvp.contract.IntergrationGetContract
import com.microple.jademall.ui.Personal.mvp.presenter.IntergrationGetPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_customer_order.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:积分收益
 */
class IntergrationGetActivity : BaseMvpActivity<IntergrationGetPresenter>(),IntergrationGetContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): IntergrationGetPresenter = IntergrationGetPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_emeralds_detail

    /**
     * 初始化数据状态
     */
    var adapter=EmeraldsDetailAdapter(arrayListOf())
    override fun initData() {
        tv_title.text="积分收益"
        getPresenter().getProfit(Constants.getToken(),intent.getStringExtra("ct_id"),intent.getStringExtra("goods_id"))
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener { adapter, view, position ->

        }
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun getProfit(profit: Profit) {
        loading.visibility=View.GONE
        adapter.setNewData(profit.profits)
    }

    companion object {
        fun startEmeraldsDetailActivity(context: Context,ct_id:String,goods_id:String){
            val intent = Intent(context,IntergrationGetActivity::class.java)
            intent.putExtra("ct_id",ct_id)
            intent.putExtra("goods_id",goods_id)
            context.startActivity(intent)
        }
    }

}
