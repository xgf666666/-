package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.SureCustomerContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.SureCustomerModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SureCustomerPresenter:SureCustomerContract.Presenter() {
    override fun createModel(): SureCustomerContract.Model =SureCustomerModel()
}