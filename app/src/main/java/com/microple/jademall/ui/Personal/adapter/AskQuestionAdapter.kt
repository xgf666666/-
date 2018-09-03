package com.microple.jademall.ui.Personal.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Ask

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class AskQuestionAdapter(data:List<Ask.ProblemBean>):BaseQuickAdapter<Ask.ProblemBean,BaseViewHolder>(R.layout.item_ask_question,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: Ask.ProblemBean?) {
        helper?.setText(R.id.tv_content,item?.problem)
    }
}