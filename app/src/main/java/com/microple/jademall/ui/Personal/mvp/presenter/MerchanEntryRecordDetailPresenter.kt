package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.MerchanEntryRecordDetailContract
import com.microple.jademall.ui.Personal.mvp.model.MerchanEntryRecordDetailModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MerchanEntryRecordDetailPresenter:MerchanEntryRecordDetailContract.Presenter() {
    override fun createModel(): MerchanEntryRecordDetailContract.Model =MerchanEntryRecordDetailModel()
}