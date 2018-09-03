package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.microple.jademall.ui.Personal.mvp.model.AddressModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AddressPresenter:AddressContract.Presenter() {
    override fun settingAddress(token: String, address_id: String) {
        getModel().settingAddress(token,address_id).ui({
            getView()?.setAddress(it.msg!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun delAddress(token: String, address_id: String) {
        getModel().delAddress(token,address_id).ui({
            getView()?.setAddress(it.msg!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun getAddress(token: String) {
        getModel().getAddress(token).ui({
            getView()?.getAddress(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun createModel(): AddressContract.Model =AddressModel()
}