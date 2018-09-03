package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.AccountIinfo
import com.microple.jademall.uitls.loadImag
import de.hdodenhof.circleimageview.CircleImageView

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class IntergrationPushAdapter(data:List<AccountIinfo.RecordBean>):BaseQuickAdapter<AccountIinfo.RecordBean,BaseViewHolder>(R.layout.item_intergration_push,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: AccountIinfo.RecordBean?) {
        helper?.setText(R.id.tv_name,item?.user_name+"    "+item?.phone)
        helper?.getView<CircleImageView>(R.id.iv_head)!!.loadImag(item?.head_img!!)
    }
}