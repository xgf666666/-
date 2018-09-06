package com.microple.jademall.ui.home.mvp.model

import com.microple.jademall.bean.GoodsDetail
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class GoodsDetailModel: GoodsDetailContract.Model {
    override fun addShoping(token: String, goods_id: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().addShopping(token,goods_id)

    override fun collection(token: String, goods_id: String) =AppApi.Api().collection(token,goods_id)

    override fun getLabel(label_id: String)=AppApi.Api().getLabel(label_id)

    override fun getDetail(token:String,goods_sn: String): Observable<BaseResponseEntity<GoodsDetail>> =AppApi.Api().getGoodsDetail(token,goods_sn)
}