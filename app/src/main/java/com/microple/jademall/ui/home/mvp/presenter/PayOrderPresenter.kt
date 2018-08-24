package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.PayOrderContract
import com.microple.jademall.ui.home.mvp.model.PayOrderModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PayOrderPresenter:PayOrderContract.Presenter() {
    override fun createModel(): PayOrderContract.Model =PayOrderModel()
}