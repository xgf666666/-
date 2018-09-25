package com.microple.jademall.ui.live.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.tencent.imsdk.TIMElemType
import com.tencent.imsdk.TIMMessage
import com.tencent.imsdk.TIMTextElem

/**
 * author: xiaoguagnfei
 * date: 2018/9/25
 * describe:
 */
class MessageAdapter :BaseQuickAdapter<TIMMessage,BaseViewHolder>(R.layout.item_livemessage) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: TIMMessage) {
            for (i in 0..(item.elementCount as Int)-1){
                var elem=item.getElement(i)
                if (elem.type== TIMElemType.Text){
                    helper?.setText(R.id.tv_name,item.priority.name)
                    helper?.setText(R.id.tv_content,(elem as TIMTextElem).text)
                }
            }

    }
}