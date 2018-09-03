package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionDetailContract


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AskQuestionDetailModel: AskQuestionDetailContract.Model {
    override fun getDetail(pt_id: String) =AppApi.Api().getAskDetail(pt_id)
}