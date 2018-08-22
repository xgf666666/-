package com.microple.jademall.ui.shoppingcar

import android.support.v4.widget.SlidingPaneLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.common.Constant
import com.microple.jademall.ui.home.activity.GoodsDetailActivity
import com.microple.jademall.ui.home.activity.ImOrderActivity
import com.microple.jademall.ui.home.adapter.HomeGoodsAdapter
import com.microple.jademall.ui.home.adapter.ImOrderAdapter
import com.microple.jademall.ui.shoppingcar.adapter.LeftAdapter
import com.microple.jademall.weight.MyRecyclerView
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_shoppingcar.*

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:购物车
 */
class ShoppingCarFragment : BaseMvpViewFragment(){
    var right=1
    var left=0
    lateinit var RightAdapter:HomeGoodsAdapter
    override fun getFragmentLayoutId(): Int = R.layout.fragment_shoppingcar

    override fun init(view: View?) {
        setTitle("购物袋")
        setHeadImage(Constant.item)
        tv_index.setOnClickListener{
            tv_content.visibility=View.GONE
            tv_index.visibility=View.GONE
        }
        tv_bianji.setOnClickListener{
            if (sl_all.isOpen)
                sl_all.closePane()
            else
                sl_all.openPane()
        }
        tv_submint.setOnClickListener{
            ImOrderActivity.startImOrderActivity(context!!)
        }
        left()
        right()

    }
    fun right(){
        RightAdapter= HomeGoodsAdapter(R.layout.item_goods)
        RightAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        cl_right.layoutManager= LinearLayoutManager(context)
        cl_right.adapter=RightAdapter
        cl_right.isNestedScrollingEnabled=false
        var data = arrayListOf( "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        RightAdapter.addData(data)
        RightAdapter.setOnItemClickListener { adapter, view, position ->
            GoodsDetailActivity.startGoodsDetailActivity(context!!)
        }
        cl_right.setOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (right!=0)
                cl_left.scrollBy(dx, dy)
            }

        })
        cl_right.setListener(object :MyRecyclerView.TouchListener{
            override fun setState() {
                right=1
                left=0
            }

        })
    }
    fun left(){
        var adapter= LeftAdapter(arrayListOf())
        cl_left.layoutManager= LinearLayoutManager(context)
        cl_left.adapter=adapter
        cl_left.isNestedScrollingEnabled=false
        var data = arrayListOf( "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            adapter.remove(position)
            RightAdapter.remove(position)
        }
        cl_left.setOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (left!=0)
                cl_right.scrollBy(dx, dy)
            }
        })
        cl_left.setListener(object :MyRecyclerView.TouchListener{
            override fun setState() {
                left=1
                right=0
            }

        })

    }
}