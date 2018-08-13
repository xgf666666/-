package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.PersonCommonBean

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:
 */
class PersonlCommonAdapter(resLayoutId: Int, mData: List<PersonCommonBean>?) : BaseQuickAdapter<PersonCommonBean, BaseViewHolder>(resLayoutId, mData) {
    override fun convert(helper: BaseViewHolder?, item: PersonCommonBean?) {
        helper!!.getView<ImageView>(R.id.iv_allOrder).setImageResource(item!!.icon)
        helper.setText(R.id.tv_allOrder,item.name)
    }
}