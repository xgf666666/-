package com.microple.jademall.ui.Personal.mvp.model


import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.FeedBackContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class FeedBackModel: FeedBackContract.Model {
    override fun getContent(token: String, content: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().getFeedBack(token,content)
}