package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.ApplyCustomerContract
import com.microple.jademall.ui.Personal.mvp.model.ApplyCustomerModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ApplyCustomerPresenter:ApplyCustomerContract.Presenter() {
    override fun createModel(): ApplyCustomerContract.Model =ApplyCustomerModel()
}