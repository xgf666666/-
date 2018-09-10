package com.microple.jademall.ui.Personal.mvp.model


import com.microple.jademall.bean.Profit
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.IntergrationGetContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class IntergrationGetModel: IntergrationGetContract.Model {
    override fun getProfit(token: String, ct_id: String, goods_id: String): Observable<BaseResponseEntity<Profit>> =AppApi.Api().profit(token, ct_id, goods_id)
}