package com.microple.jademall.ui.live

import android.content.Intent
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.live.adapter.LiveHotAdapter
import com.microple.jademall.ui.live.adapter.LiveRecommendAdapter
import com.microple.jademall.ui.live.adapter.LiveReviewAdapter
import com.microple.jademall.common.Constant
import com.microple.jademall.ui.live.activity.LiveDetailsActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import com.xx.baseuilibrary.widget.DividerListItemDecoration
import kotlinx.android.synthetic.main.fragment_live.*
import kotlinx.android.synthetic.main.fragment_tool_bar.*

/**
 * author: linfeng
 * date: 2018/8/6.
 * describe:直播
 */
class LiveFragment : BaseMvpViewFragment(),BaseQuickAdapter.OnItemClickListener {



    private var mLiveHotAdapter = LiveHotAdapter(R.layout.item_live_hot)
    private var mLiveReviewAdapter = LiveReviewAdapter(R.layout.item_live_hot)
    private var mLiveRecommendAdapter = LiveRecommendAdapter(R.layout.item_live_recommend)

    override fun getFragmentLayoutId(): Int = R.layout.fragment_live

    override fun init(view: View?) {
//        setTitle("直播")
//        setHeadImage(Constant.item)
//        setBackVisibility(false)
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")

        //正在热播
        mLiveHotAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        val layoutHotManager = LinearLayoutManager(context)
        layoutHotManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_hotLive.layoutManager = layoutHotManager
        rv_hotLive.adapter = mLiveHotAdapter
        rv_hotLive.isNestedScrollingEnabled = false
        mLiveHotAdapter.addData(data)
        mLiveHotAdapter.notifyDataSetChanged()
        mLiveHotAdapter.setOnItemClickListener(this)



        //精彩回顾
        mLiveReviewAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        val layoutReviewManager = LinearLayoutManager(context)
        layoutReviewManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_reviewLive.layoutManager = layoutReviewManager
        rv_reviewLive.adapter = mLiveReviewAdapter
        rv_reviewLive.isNestedScrollingEnabled = false
        mLiveReviewAdapter.addData(data)
        mLiveReviewAdapter.notifyDataSetChanged()


        //为您推荐
        mLiveRecommendAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        rv_recommendLive.layoutManager = LinearLayoutManager(context)
        rv_recommendLive.isNestedScrollingEnabled = false
        rv_recommendLive.addItemDecoration(DividerListItemDecoration(context,R.drawable.divider_gray,false,true))
        rv_recommendLive.adapter = mLiveRecommendAdapter
        mLiveRecommendAdapter.addData(data)
        mLiveRecommendAdapter.notifyDataSetChanged()
        scrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if (scrollY>=90){
                tv_title.visibility=View.VISIBLE
                tv_title.text="直播"
            }else{
                tv_title.visibility=View.GONE
            }
        }

    }
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        startActivity(Intent(context,LiveDetailsActivity::class.java))
    }
}


