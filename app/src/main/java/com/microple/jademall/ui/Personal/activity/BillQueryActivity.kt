package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.PointBean
import com.microple.jademall.bean.PointDetail
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.BillQueryAdapter
import com.microple.jademall.ui.Personal.mvp.contract.BillQuestContract
import com.microple.jademall.ui.Personal.mvp.presenter.BillQuestPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_bill_query.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:积分明细
 */
class BillQueryActivity : BaseMvpActivity<BillQuestPresenter>(),BillQuestContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): BillQuestPresenter = BillQuestPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_bill_query

    /**
     * 初始化数据状态
     */
    var adapter=BillQueryAdapter(arrayListOf())
    override fun initData() {
        tv_title.text="积分明细"
//        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
//        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            IntergrationDetailActivity.startIntergrationDetailActivity(this,""+(adapter as BillQueryAdapter).data[position].up_id)
        }
        getPresenter().getPoint(Constants.getToken())
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }

    }

    override fun getPoint(pointDetail: PointDetail) {
        var data=ArrayList<PointBean>()
        if (pointDetail.user_point.size!=0)
        for (i in 0..pointDetail.user_point.size-1){
            if (pointDetail.user_point[i].list.size!=0)
            for (y in 0..pointDetail.user_point[i].list.size-1){
                if (y==0){
                    var pointBean=PointBean()
                    pointBean.year=pointDetail.user_point[i].year
                    pointBean.month=pointDetail.user_point[i].month
                    pointBean.has=true
                    pointBean.up_id=pointDetail.user_point[i].list[y].up_id
                    pointBean.user_id=pointDetail.user_point[i].list[y].user_id
                    pointBean.type=pointDetail.user_point[i].list[y].type
                    pointBean.points=pointDetail.user_point[i].list[y].points
                    pointBean.text=pointDetail.user_point[i].list[y].text
                    pointBean.add_time=pointDetail.user_point[i].list[y].add_time
                    pointBean.order_sn=pointDetail.user_point[i].list[y].order_sn
                    pointBean.points_change=pointDetail.user_point[i].list[y].points_change
                    data.add(pointBean)
                }else{
                    var pointBean=PointBean()
                    pointBean.up_id=pointDetail.user_point[i].list[y].up_id
                    pointBean.user_id=pointDetail.user_point[i].list[y].user_id
                    pointBean.type=pointDetail.user_point[i].list[y].type
                    pointBean.points=pointDetail.user_point[i].list[y].points
                    pointBean.text=pointDetail.user_point[i].list[y].text
                    pointBean.add_time=pointDetail.user_point[i].list[y].add_time
                    pointBean.order_sn=pointDetail.user_point[i].list[y].order_sn
                    pointBean.points_change=pointDetail.user_point[i].list[y].points_change
                    data.add(pointBean)
                }
            }
        }
        loading.visibility= View.GONE
        adapter.setNewData(data)
    }

    companion object {
        fun startBillQueryActivity(context: Context){
            val intent = Intent(context,BillQueryActivity::class.java)
            context.startActivity(intent)
        }
    }

}
