package com.microple.jademall.ui.Personal.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Record

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class MerchantEntryRecordAdapter(data:List<Record.ApplyListBean>):BaseQuickAdapter<Record.ApplyListBean,BaseViewHolder>(R.layout.item_merchant_record,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: Record.ApplyListBean?) {
        helper?.setText(R.id.tv_content,item?.supplier_name)
                ?.setText(R.id.tv_type,item?.status_desc)

    }
}