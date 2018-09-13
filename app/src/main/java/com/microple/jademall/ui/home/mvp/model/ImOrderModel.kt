package com.microple.jademall.ui.home.mvp.model

import com.microple.jademall.bean.ImOrder
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.home.mvp.contract.ImOrderContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ImOrderModel: ImOrderContract.Model {
    override fun imOrder(token: String, sb_id: String, goods_id: String): Observable<BaseResponseEntity<ImOrder>> =
            AppApi.Api().imOrder(token,sb_id,goods_id)
}