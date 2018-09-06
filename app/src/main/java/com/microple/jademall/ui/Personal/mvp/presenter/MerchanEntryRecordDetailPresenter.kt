package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.MerchanEntryRecordDetailContract
import com.microple.jademall.ui.Personal.mvp.model.MerchanEntryRecordDetailModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MerchanEntryRecordDetailPresenter:MerchanEntryRecordDetailContract.Presenter() {
    override fun getRecordDetail(token: String, supplier_id: String) {
        getModel().getRecordDetail(token,supplier_id).ui({
            getView()?.getRecordDetail(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): MerchanEntryRecordDetailContract.Model =MerchanEntryRecordDetailModel()
}