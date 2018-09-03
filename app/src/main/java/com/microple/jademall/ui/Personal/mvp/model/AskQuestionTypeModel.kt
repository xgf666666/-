package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.AskType
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionTypeContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AskQuestionTypeModel: AskQuestionTypeContract.Model {
    override fun getType(): Observable<BaseResponseEntity<AskType>> = AppApi.Api().askType
}