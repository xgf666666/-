package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MerchantEntryRecordContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.MerchantEntryRecordModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MerchantRecordPresenter:MerchantEntryRecordContract.Presenter() {
    override fun getRecord(token: String) {
        getModel().getRecord(token).ui({
            getView()?.getRecord(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): MerchantEntryRecordContract.Model =MerchantEntryRecordModel()
}