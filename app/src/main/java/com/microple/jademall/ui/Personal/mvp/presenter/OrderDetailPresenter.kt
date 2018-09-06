package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.OrderDetailContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.OrderDetailModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class OrderDetailPresenter:OrderDetailContract.Presenter() {
    override fun sureOrder(token: String, order_id: String) {
        getModel().sureOrder(token,order_id).ui({
            getView()?.sureOrder()
        },{
            getView()?.showToast(it)
        })
    }

    override fun exitOrder(token: String, order_id: String) {
        getModel().exitOrder(token,order_id).ui({
            getView()?.exitOrder()
        },{
            getView()?.showToast(it)

        })
    }

    override fun getDetail(token: String, order_id: String) {
        getModel().getDetail(token,order_id).ui({
            getView()?.getDetail(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): OrderDetailContract.Model =OrderDetailModel()
}