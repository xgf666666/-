package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Collection
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.microple.jademall.ui.Personal.mvp.contract.MyCollectionContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyCollectionModel: MyCollectionContract.Model {
    override fun getzujiList(token: String): Observable<BaseResponseEntity<Collection>> =AppApi.Api().getZujiList(token)

    override fun getCollection(token: String): Observable<BaseResponseEntity<Collection>> =AppApi.Api().getCollection(token)
}