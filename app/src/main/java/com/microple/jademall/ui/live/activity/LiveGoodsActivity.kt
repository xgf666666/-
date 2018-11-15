package com.microple.jademall.ui.live.activity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.LiveGoods
import com.microple.jademall.common.App
import com.microple.jademall.ui.home.activity.GoodsDetailActivity
import com.microple.jademall.ui.live.adapter.LiveGoodsAdapter
import com.microple.jademall.ui.live.mvp.contract.LiveGoodsContract
import com.microple.jademall.ui.live.mvp.presenter.LiveGoodsPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_live_goods.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguangfei
 * date: 2018/11/3.
 * describe: 直播商品页面
 */
class LiveGoodsActivity : BaseMvpActivity<LiveGoodsPresenter>(),LiveGoodsContract.View {
    override fun getGoods(liveGoods: LiveGoods) {
        dismissLoadingDialog()
        mAdapter.setNewData(liveGoods.goods)

    }

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_live_goods

    /**
     * 初始化数据状态
     */
    private var mAdapter = LiveGoodsAdapter(R.layout.item_goods)
    override fun initData() {
        (application as App).addActivity(this)
        tv_title.text="直播间商品"
        showLoadingDialog()
        getPresenter().getGoods(intent.getStringExtra("live_id"))
        iv_back.setOnClickListener {finish()}
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
        mAdapter.setOnItemClickListener { adapter, view, position ->
            GoodsDetailActivity.startGoodsDetailActivity(this,(adapter as LiveGoodsAdapter).data[position].goods_sn)
        }
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): LiveGoodsPresenter =LiveGoodsPresenter()
    companion object {
        fun startGoodsActivity(context: Context, live_id:String){
            val intent = Intent(context, LiveGoodsActivity::class.java)
            intent.putExtra("live_id",live_id)
            context.startActivity(intent)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        (application as App).deleteActivity(this)
    }

}
