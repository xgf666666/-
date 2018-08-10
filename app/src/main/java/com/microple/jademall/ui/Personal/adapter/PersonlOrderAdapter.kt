package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.bean.PersonOrderBean

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:
 */
class PersonlOrderAdapter(resLayoutId: Int, mData: List<PersonOrderBean>?) : BaseQuickAdapter<PersonOrderBean, BaseViewHolder>(resLayoutId, mData) {
    override fun convert(helper: BaseViewHolder?, mItem: PersonOrderBean?) {
        helper!!.getView<ImageView>(R.id.iv_allOrder).setImageResource(mItem!!.icon)
        helper.setText(R.id.tv_allOrder,mItem.name)
    }
}