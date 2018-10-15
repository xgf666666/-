package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.uitls.loadImag

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class ImageDetailAdapter(data:List<String>):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_imagedetail,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: String?) {
        var layoutParams=helper?.getView<ImageView>(R.id.image)?.layoutParams
        layoutParams?.height=layoutParams?.width!!
        helper?.getView<ImageView>(R.id.image)?.layoutParams=layoutParams
        helper?.getView<ImageView>(R.id.image)!!.loadImag(item!!)

    }
}