package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.bean.RecordDetail
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.MerchanEntryRecordDetailContract
import com.microple.jademall.ui.Personal.mvp.presenter.MerchanEntryRecordDetailPresenter
import com.microple.jademall.uitls.loadImag
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_merchant_entry_record_detail.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商家入驻申请记录详情
 */
class MerchantEntryRecordDetailActivity : BaseMvpActivity<MerchanEntryRecordDetailPresenter>(),MerchanEntryRecordDetailContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): MerchanEntryRecordDetailPresenter = MerchanEntryRecordDetailPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_merchant_entry_record_detail


    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="商家入驻申请记录详情"
        var supplier_id=intent.getStringExtra("supplier_id")
        Log.i("supplier_id",supplier_id)
        getPresenter().getRecordDetail(Constants.getToken(),supplier_id)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        tv_kefu.setOnClickListener{
            CustomerServiceAcitivity.startCustomerServiceAcitivity(this)
        }
    }

    override fun getRecordDetail(record: RecordDetail) {
        loading.visibility= View.GONE
        tv_time.text=record.apply_info.created_time
        tv_email.text=record.apply_info.email
        tv_phone.text= record.apply_info.phone
        tv_yaoqingren.text=record.apply_info.inviter
        if (record.apply_info.license!=null)
        iv_yingye.loadImag(record.apply_info.license)
        if(record.apply_info.attachment!=null)
        iv_fujian.loadImag(record.apply_info.attachment)
    }

    companion object {
        fun startMerchantEntryRecordDetailActivity(context: Context,supplier_id:String){
            val intent = Intent(context,MerchantEntryRecordDetailActivity::class.java)
            intent.putExtra("supplier_id",supplier_id)
            context.startActivity(intent)
        }
    }
}
