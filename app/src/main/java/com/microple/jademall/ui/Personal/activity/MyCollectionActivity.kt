package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Collection
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.AllOrderAdapter
import com.microple.jademall.ui.Personal.adapter.MyContectionAdapter
import com.microple.jademall.ui.Personal.mvp.contract.MyCollectionContract
import com.microple.jademall.ui.Personal.mvp.presenter.MyCollectionPresenter
import com.microple.jademall.ui.home.activity.GoodsDetailActivity
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_my_collection.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:我的收藏
 */

class MyCollectionActivity : BaseMvpActivity<MyCollectionPresenter>(),MyCollectionContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): MyCollectionPresenter = MyCollectionPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_my_collection

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="我的收藏"
        getPresenter().getCollection(Constants.getToken())
//        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
//        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            GoodsDetailActivity.startGoodsDetailActivity(this,(adapter as MyContectionAdapter).data[position].goods_sn)
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

    override fun getCollection(collection: Collection) {
        loading.visibility= View.GONE
        adapter.setNewData(collection.list)
    }

    companion object {
        fun startMyCollectionActivity(context: Context){
            val intent = Intent(context,MyCollectionActivity::class.java)
            context.startActivity(intent)
        }
    }

    var adapter = MyContectionAdapter(arrayListOf())
}
