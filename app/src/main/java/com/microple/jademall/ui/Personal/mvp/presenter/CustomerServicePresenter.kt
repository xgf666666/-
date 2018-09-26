package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.CustomerServiceContract
import com.microple.jademall.ui.Personal.mvp.model.CustomerServiceModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class CustomerServicePresenter:CustomerServiceContract.Presenter() {
    override fun getphone() {
        getModel().getPhone().ui({
            getView()?.getPhone(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): CustomerServiceContract.Model =CustomerServiceModel()
}