package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.activity.IntergrationDetailActivity
import com.microple.jademall.ui.Personal.adapter.BillQueryAdapter
import com.microple.jademall.ui.Personal.adapter.ImageDetailAdapter
import com.microple.jademall.ui.home.mvp.contract.ImageDetailContract
import com.microple.jademall.ui.home.mvp.presenter.ImageDetailPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_image_detail.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商品详情图片
 */
class ImageDetailActivity : BaseMvpActivity<ImageDetailPresenter>(), ImageDetailContract.View {
    var data: ArrayList<String>? = null
    override fun getImageDetail(goods_content: String) {
        var imgs = goods_content.split(",")
        data = ArrayList<String>()
        if (imgs.size != 0)
            for (i in 0..imgs.size - 1) {
                data?.add(imgs[i])
            }
        var adapter = ImageDetailAdapter(data as List<String>)
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        loading.visibility = View.GONE
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): ImageDetailPresenter = ImageDetailPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int = R.layout.activity_image_detail

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text = "图片详情"
        getPresenter().getImgageDetail(intent.getStringExtra("goods_id"))

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun startImageDetailActivity(context: Context, goods_id: String) {
            val intent = Intent(context, ImageDetailActivity::class.java)
            intent.putExtra("goods_id", goods_id)
            context.startActivity(intent)
        }
    }
}
