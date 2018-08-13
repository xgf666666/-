package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.PersonHelpBean

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:
 */
class PersonlHelpAdapter(resLayoutId: Int, mData: List<PersonHelpBean>?) : BaseQuickAdapter<PersonHelpBean, BaseViewHolder>(resLayoutId, mData) {
    override fun convert(helper: BaseViewHolder?, item: PersonHelpBean?) {
        helper!!.getView<ImageView>(R.id.iv_allOrder).setImageResource(item!!.icon)
        helper.setText(R.id.tv_allOrder,item.name)
    }
}