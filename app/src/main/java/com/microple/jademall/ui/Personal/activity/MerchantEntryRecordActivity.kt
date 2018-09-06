package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Record
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.MerchantEntryRecordAdapter
import com.microple.jademall.ui.Personal.mvp.contract.MerchantEntryRecordContract
import com.microple.jademall.ui.Personal.mvp.presenter.MerchantRecordPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_merchant_entry_record.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商家入驻申请记录
 */
class MerchantEntryRecordActivity : BaseMvpActivity<MerchantRecordPresenter>(),MerchantEntryRecordContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): MerchantRecordPresenter = MerchantRecordPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_merchant_entry_record

    /**
     * 初始化数据状态
     */
    var adapter= MerchantEntryRecordAdapter(arrayListOf())
    override fun initData() {
        tv_title.text="商家入驻申请记录"
        getPresenter().getRecord(Constants.getToken())
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            MerchantEntryRecordDetailActivity.startMerchantEntryRecordDetailActivity(this,""+(adapter as MerchantEntryRecordAdapter).data[position].supplier_id)

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

    override fun getRecord(record: Record) {
        loading.visibility= View.GONE
        adapter.setNewData(record.apply_list)
    }

    companion object {
        fun startMerchantEntryRecordActivity(context: Context){
            val intent = Intent(context,MerchantEntryRecordActivity::class.java)
            context.startActivity(intent)
        }
    }

}
