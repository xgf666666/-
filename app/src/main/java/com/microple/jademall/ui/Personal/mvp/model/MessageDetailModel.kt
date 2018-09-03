package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.MessageDetail
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MessageDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MessageDetailModel: MessageDetailContract.Model {
    override fun getMessageDetail(token: String,msg_id:String) : Observable<BaseResponseEntity<MessageDetail>> =AppApi.Api().getMessageDetail(token,msg_id)
}