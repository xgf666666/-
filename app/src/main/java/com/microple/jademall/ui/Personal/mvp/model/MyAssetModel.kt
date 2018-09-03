package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Assert
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MyAssetContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyAssetModel: MyAssetContract.Model {
    override fun getMyAssert(token: String): Observable<BaseResponseEntity<Assert>> =AppApi.Api().getMyAssert(token)



}