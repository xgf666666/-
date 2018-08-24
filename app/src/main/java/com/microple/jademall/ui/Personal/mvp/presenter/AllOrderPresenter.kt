package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AllOrderContract
import com.microple.jademall.ui.Personal.mvp.model.AllOrderModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AllOrderPresenter:AllOrderContract.Presenter() {
    override fun createModel(): AllOrderContract.Model =AllOrderModel()
}