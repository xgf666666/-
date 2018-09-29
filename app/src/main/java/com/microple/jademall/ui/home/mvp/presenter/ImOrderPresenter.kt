package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.ImOrderContract
import com.microple.jademall.ui.home.mvp.model.ImOrderModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ImOrderPresenter:ImOrderContract.Presenter() {
    override fun pay(token: String, send: String, live: String, cabinet: String, address_id: String, pay_type: String,trade_password:String,sb_id:String,pick_type:String,ct_id:String) {
        getModel().pay(token,send,live,cabinet,address_id,pay_type,trade_password,sb_id,pick_type,ct_id).ui({
            getView()?.pay(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun imOrder(token: String, sb_id: String, goods_id: String) {
            getModel().imOrder(token,sb_id,goods_id).ui({
                getView()?.imOrder(it.data!!)
            },{
                getView()?.showToast(it)
            })
    }

    override fun createModel(): ImOrderContract.Model =ImOrderModel()
}