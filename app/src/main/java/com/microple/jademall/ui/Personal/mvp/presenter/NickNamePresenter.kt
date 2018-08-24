package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.microple.jademall.ui.Personal.mvp.contract.NickNameContract
import com.microple.jademall.ui.Personal.mvp.model.AddressModel
import com.microple.jademall.ui.Personal.mvp.model.NickNameModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class NickNamePresenter:NickNameContract.Presenter() {
    override fun createModel(): NickNameContract.Model =NickNameModel()
}