package com.microple.jademall.ui.Personal.adapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class MyAppointmentAdapter(data:List<String>):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_myappointment,data) {

    override fun convert(helper: BaseViewHolder?, item: String?) {
    }
}