package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.CustomerOrderContract
import com.microple.jademall.ui.Personal.mvp.model.CustomerOrderModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class CustomerOrderPresenter:CustomerOrderContract.Presenter() {
    override fun createModel(): CustomerOrderContract.Model =CustomerOrderModel()
}