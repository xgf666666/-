package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.EditAddressContract
import com.microple.jademall.ui.Personal.mvp.model.EditAddressModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class EditAddressPresenter:EditAddressContract.Presenter() {
    override fun createModel(): EditAddressContract.Model =EditAddressModel()
}