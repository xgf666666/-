package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.PickGoodsContract
import com.microple.jademall.ui.Personal.mvp.model.PickGoodsModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PickGoodsPresenter:PickGoodsContract.Presenter() {
    override fun pick(token: String, ct_id: String) {
        getModel().pick(token,ct_id).ui({
            getView()?.pick(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): PickGoodsContract.Model =PickGoodsModel()
}