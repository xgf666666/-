package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Pay
import com.microple.jademall.bean.Pick
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.PickGoodsContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PickGoodsModel: PickGoodsContract.Model {
    override fun pay(token: String, send: String, live: String, cabinet: String, address_id: String, pay_type: String, trade_password: String, sb_id: String, pick_type: String, ct_id: String): Observable<BaseResponseEntity<Pay>> =
            AppApi.Api().pay(token,send,live,cabinet,address_id,pay_type,trade_password,sb_id,"","","")

    override fun pick(token: String, ct_id: String): Observable<BaseResponseEntity<Pick>> =AppApi.Api().pick(token, ct_id)
}