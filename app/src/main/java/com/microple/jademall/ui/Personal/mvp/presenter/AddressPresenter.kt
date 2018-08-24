package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.microple.jademall.ui.Personal.mvp.model.AddressModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AddressPresenter:AddressContract.Presenter() {
    override fun createModel(): AddressContract.Model =AddressModel()
}