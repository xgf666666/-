package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Record
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MerchantEntryRecordContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MerchantEntryRecordModel: MerchantEntryRecordContract.Model {
    override fun getRecord(token: String): Observable<BaseResponseEntity<Record>> =AppApi.Api().getRecord(token)
}