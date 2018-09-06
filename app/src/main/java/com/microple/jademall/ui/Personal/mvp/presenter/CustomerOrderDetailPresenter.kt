package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.CusetomerOrderDetailContract
import com.microple.jademall.ui.Personal.mvp.model.CustomerOrderDetailModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class CustomerOrderDetailPresenter:CusetomerOrderDetailContract.Presenter() {
    override fun sendBack(token: String, as_id: String, shipping_name: String, shipping_code: String) {
        getModel().sendBack(token,as_id,shipping_name,shipping_code).ui({
            getView()?.sendBack()
        },{
            getView()?.showToast(it)
        })
    }

    override fun getDetail(token: String, as_id: String) {
        getModel().getDetail(token,as_id).ui({
            getView()?.getDetail(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): CusetomerOrderDetailContract.Model =CustomerOrderDetailModel()
}