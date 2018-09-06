package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.CustomerOrderContract
import com.microple.jademall.ui.Personal.mvp.model.CustomerOrderModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class CustomerOrderPresenter:CustomerOrderContract.Presenter() {
    override fun getCustomer(token: String) {
        getModel().getCustomer(token).ui({
            getView()?.getCustomer(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): CustomerOrderContract.Model =CustomerOrderModel()
}