package com.microple.jademall.ui.shoppingcar.mvp.model

import com.microple.jademall.bean.Shop
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.shoppingcar.mvp.contract.ShoppingCarContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ShoppingCarModel: ShoppingCarContract.Model {
    override fun shop(token: String): Observable<BaseResponseEntity<Shop>> =AppApi.Api().shopping(token)

    override fun delShop(token: String, sb_id: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().delShopping(token,sb_id)

    override fun updateShop(token: String): Observable<BaseResponseEntity<Shop>> =AppApi.Api().updateShopping(token)
}