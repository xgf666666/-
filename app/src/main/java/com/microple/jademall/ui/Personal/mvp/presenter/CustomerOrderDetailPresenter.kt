package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.CusetomerOrderDetailContract
import com.microple.jademall.ui.Personal.mvp.model.CustomerOrderDetailModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class CustomerOrderDetailPresenter:CusetomerOrderDetailContract.Presenter() {
    override fun createModel(): CusetomerOrderDetailContract.Model =CustomerOrderDetailModel()
}