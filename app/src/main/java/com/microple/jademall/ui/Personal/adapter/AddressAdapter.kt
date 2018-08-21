package com.microple.jademall.ui.Personal.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class AddressAdapter(data:List<String>):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_address,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.addOnClickListener(R.id.tv_bianji)
        helper?.addOnClickListener(R.id.tv_del)
        helper?.addOnClickListener(R.id.tv_setting)
    }
}