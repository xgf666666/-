package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.MerchanEntryRecordContract
import com.microple.jademall.ui.Personal.mvp.model.MerchanEntryRecordModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MerchanEntryRecordPresenter:MerchanEntryRecordContract.Presenter() {
    override fun createModel(): MerchanEntryRecordContract.Model =MerchanEntryRecordModel()
}