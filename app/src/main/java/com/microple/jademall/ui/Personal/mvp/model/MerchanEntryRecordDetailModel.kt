package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.RecordDetail
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.MerchanEntryRecordDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MerchanEntryRecordDetailModel: MerchanEntryRecordDetailContract.Model {
    override fun getRecordDetail(token: String, supplier_id: String): Observable<BaseResponseEntity<RecordDetail>> =
            AppApi.Api().getRecordDetail(token,supplier_id)
}