package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.PersonSettingBean

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:
 */
class PersonlSettingAdapter(resLayoutId: Int, mData: List<PersonSettingBean>?) : BaseQuickAdapter<PersonSettingBean, BaseViewHolder>(resLayoutId, mData) {
    override fun convert(helper: BaseViewHolder?, item: PersonSettingBean?) {
        helper!!.getView<ImageView>(R.id.iv_allOrder).setImageResource(item!!.icon)
        helper.setText(R.id.tv_allOrder,item.name)
    }
}