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
    override fun pay(token: String, send: String, live: String, cabinet: String, address_id: String, pay_type: String, trade_password: String, sb_id: String, pick_type: String, ct_id: String) {
        getModel().pay(token,send,live,cabinet,address_id,pay_type,trade_password,sb_id,pick_type,ct_id).ui({
            getView()?.pay(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun pick(token: String, ct_id: String) {
        getModel().pick(token,ct_id).ui({
            getView()?.pick(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): PickGoodsContract.Model =PickGoodsModel()
}