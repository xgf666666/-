package com.microple.jademall.ui.Personal.adapter

import android.graphics.Color
import android.widget.CheckBox
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Address

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class AddressAdapter(data:List<Address.AddressBean>):BaseQuickAdapter<Address.AddressBean,BaseViewHolder>(R.layout.item_address,data) {
    var positon:Int=100000000
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    fun setCheck(positon:Int){
        this.positon=positon
        notifyDataSetChanged()
    }
    override fun convert(helper: BaseViewHolder?, item: Address.AddressBean?) {
        helper?.setText(R.id.tv_name,item?.consigner+"    "+item?.phone)
                ?.setText(R.id.tv_address,item?.address)
        helper?.addOnClickListener(R.id.tv_bianji)
        helper?.addOnClickListener(R.id.tv_del)
        helper?.addOnClickListener(R.id.tv_setting)
                ?.getView<CheckBox>(R.id.tv_setting)?.isSelected=true

        if (item?.is_default==1){
            helper?.getView<CheckBox>(R.id.tv_setting)?.isChecked=true
            helper?.getView<CheckBox>(R.id.tv_setting)?.setTextColor(Color.parseColor("#06A366"))
        }else{
            helper?.getView<CheckBox>(R.id.tv_setting)?.isChecked=false
            helper?.getView<CheckBox>(R.id.tv_setting)?.setTextColor(Color.parseColor("#000000"))
        }
        if (positon!=100000000)
            if (helper?.adapterPosition==positon){
                helper?.getView<CheckBox>(R.id.tv_setting)?.isChecked=true
                helper?.getView<CheckBox>(R.id.tv_setting)?.setTextColor(Color.parseColor("#06A366"))
            }else{
                helper?.getView<CheckBox>(R.id.tv_setting)?.isChecked=false
                helper?.getView<CheckBox>(R.id.tv_setting)?.setTextColor(Color.parseColor("#000000"))
            }
    }

}