package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.EmeraldsDetailContract
import com.microple.jademall.ui.Personal.mvp.model.EmeraldsDetailModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class EmeraldsDetailPresenter:EmeraldsDetailContract.Presenter() {
    override fun exchange(token: String, ct_id: String) {
        getModel().exchange(token,ct_id).ui({
            getView()?.exchange()
        },{
            getView()?.showToast(it)
        })

    }

    override fun getEmeraldsDetail(token: String,ct_id: String) {
        getModel().getEmeraldsDetail(token,ct_id).ui({
            getView()?.getEmeraldsDetail(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): EmeraldsDetailContract.Model =EmeraldsDetailModel()
}