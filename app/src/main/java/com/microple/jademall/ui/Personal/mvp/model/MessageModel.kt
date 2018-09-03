package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.MyMessage
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.MessageContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MessageModel: MessageContract.Model {
    override fun getMessage(token: String): Observable<BaseResponseEntity<MyMessage>> =AppApi.Api().getMessage(token)
}