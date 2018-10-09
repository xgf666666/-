package com.microple.jademall.ui.live

import android.content.Intent
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.LiveList
import com.microple.jademall.ui.live.adapter.LiveHotAdapter
import com.microple.jademall.ui.live.adapter.LiveRecommendAdapter
import com.microple.jademall.ui.live.adapter.LiveReviewAdapter
import com.microple.jademall.common.Constant
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.live.activity.LiveDetailsActivity
import com.microple.jademall.ui.live.activity.LivePlayerActivity
import com.microple.jademall.ui.live.adapter.LiveYuyueAdapter
import com.microple.jademall.ui.live.mvp.contract.LiveContract
import com.microple.jademall.ui.live.mvp.presenter.LivePresenter
import com.microple.jademall.uitls.loadHeadImag
import com.microple.jademall.uitls.loadImag
import com.xx.baseuilibrary.mvp.BaseMvpFragment
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import com.xx.baseuilibrary.widget.DividerListItemDecoration

import kotlinx.android.synthetic.main.fragment_live.*
import kotlinx.android.synthetic.main.fragment_tool_bar.*

/**
 * author: linfeng
 * date: 2018/8/6.
 * describe:直播
 */
class LiveFragment : BaseMvpFragment<LiveContract.Model,LiveContract.View,LivePresenter>(),LiveContract.View{
    override fun liveList(liveList: LiveList) {
        loading.visibility=View.GONE
        if (liveList.live_now.size==0){
            tv_tishi.visibility=View.VISIBLE
        }else{
            tv_tishi.visibility=View.GONE
        }
        if (liveList.replay_list.size==0){
            tv_tishi_two.visibility=View.VISIBLE
        }else{
            tv_tishi_two.visibility=View.GONE
        }
        if (liveList.reco_live.size==0){
            tv_tishi_three.visibility=View.VISIBLE
        }else{
            tv_tishi_three.visibility=View.GONE
        }
        liveYuyueAdapter.setNewData(liveList.appoint_live)
        mLiveHotAdapter.setNewData(liveList.live_now)
        mLiveReviewAdapter.setNewData(liveList.replay_list)
        mLiveRecommendAdapter.setNewData(liveList.reco_live)
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): LivePresenter = LivePresenter()

    private var mLiveHotAdapter = LiveHotAdapter(R.layout.item_live_hot)
    private var mLiveReviewAdapter = LiveReviewAdapter(R.layout.item_live_hot)
    private var mLiveRecommendAdapter = LiveRecommendAdapter(R.layout.item_live_recommend)
    private var liveYuyueAdapter = LiveYuyueAdapter()

    override fun getFragmentLayoutId(): Int = R.layout.fragment_live

    override fun init(view: View?) {
        if (Constants.isLogin()){
            iv_head.loadHeadImag(Constants.getHeadImg())
        }else{
            iv_head.setImageResource(R.drawable.datouxiang_)
        }
        if (Constants.isLogin()){
            getPresenter().liveList(Constants.getToken())
        }else{
            getPresenter().liveList("")
        }
        //预约
        liveYuyueAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        rv_yuyueLive.layoutManager=LinearLayoutManager(context)
        rv_yuyueLive.adapter=liveYuyueAdapter
        rv_yuyueLive.isNestedScrollingEnabled=false
//        liveYuyueAdapter.addData(data)
        //正在热播
        mLiveHotAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        val layoutHotManager = LinearLayoutManager(context)
        layoutHotManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_hotLive.layoutManager = layoutHotManager
        rv_hotLive.adapter = mLiveHotAdapter
        rv_hotLive.isNestedScrollingEnabled = false
//        mLiveHotAdapter.addData(data)
        mLiveHotAdapter.setOnItemClickListener { adapter, view, position ->
//            LiveDetailsActivity.startLiveDetail(context!!,""+(adapter as LiveHotAdapter).data[position].live_id)
            LivePlayerActivity.startLivePlayerActivity(context!!,""+(adapter as LiveHotAdapter).data[position].live_id,adapter.data[position].play_url[0])
        }



        //精彩回顾
        mLiveReviewAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        val layoutReviewManager = LinearLayoutManager(context)
        layoutReviewManager.orientation = LinearLayoutManager.HORIZONTAL
        rv_reviewLive.layoutManager = layoutReviewManager
        rv_reviewLive.adapter = mLiveReviewAdapter
        rv_reviewLive.isNestedScrollingEnabled = false
//        mLiveReviewAdapter.addData(data)
        mLiveReviewAdapter.notifyDataSetChanged()
        mLiveReviewAdapter.setOnItemClickListener { adapter, view, position ->
            LiveDetailsActivity.startLiveDetail(context!!,""+(adapter as LiveReviewAdapter).data[position].lr_id)
        }


        //为您推荐
        mLiveRecommendAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        rv_recommendLive.layoutManager = LinearLayoutManager(context)
        rv_recommendLive.isNestedScrollingEnabled = false
        rv_recommendLive.addItemDecoration(DividerListItemDecoration(context,R.drawable.divider_gray,false,true))
        rv_recommendLive.adapter = mLiveRecommendAdapter
//        mLiveRecommendAdapter.addData(data)
        mLiveRecommendAdapter.notifyDataSetChanged()
        mLiveRecommendAdapter.setOnItemClickListener { adapter, view, position ->
            LiveDetailsActivity.startLiveDetail(context!!,""+(adapter as LiveRecommendAdapter).data[position].live_id)
        }
        scrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if (scrollY>=90){
                tv_title.visibility=View.VISIBLE
                tv_title.text="直播"
            }else{
                tv_title.visibility=View.GONE
            }
        }

    }
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden){
            if (Constants.isLogin()){
                iv_head.loadHeadImag(Constants.getPersonal().head_img)
            }else{
                iv_head.setImageResource(R.drawable.datouxiang_)
            }
        }
    }

}


