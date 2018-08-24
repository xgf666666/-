package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.ImOrderContract
import com.microple.jademall.ui.home.mvp.model.ImOrderModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ImOrderPresenter:ImOrderContract.Presenter() {
    override fun createModel(): ImOrderContract.Model =ImOrderModel()
}