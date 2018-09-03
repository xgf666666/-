package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Ask
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AskQuestionModel: AskQuestionContract.Model {
    override fun getAsk(pt_id: String): Observable<BaseResponseEntity<Ask>> =AppApi.Api().getAsk(pt_id)
}