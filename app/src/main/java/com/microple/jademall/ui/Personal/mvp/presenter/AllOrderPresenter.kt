package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AllOrderContract
import com.microple.jademall.ui.Personal.mvp.model.AllOrderModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AllOrderPresenter:AllOrderContract.Presenter() {
    override fun getOrder(token: String, order_status: String) {
        getModel().getOrder(token,order_status).ui({
            getView()?.getOrder(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): AllOrderContract.Model =AllOrderModel()
}