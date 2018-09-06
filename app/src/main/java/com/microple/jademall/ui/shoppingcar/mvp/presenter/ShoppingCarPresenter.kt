package com.microple.jademall.ui.shoppingcar.mvp.presenter

import com.microple.jademall.ui.shoppingcar.mvp.contract.ShoppingCarContract
import com.microple.jademall.ui.shoppingcar.mvp.model.ShoppingCarModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ShoppingCarPresenter:ShoppingCarContract.Presenter() {
    override fun shop(token: String) {
        getModel().shop(token).ui({
            getView()?.shop(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun delShop(token: String, sb_id: String) {
       getModel().delShop(token,sb_id).ui({
           getView()?.delShop()
       },{
           getView()?.showToast(it)
       })
    }

    override fun updateShop(token: String) {
        getModel().updateShop(token).ui({
            getView()?.updateShop(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): ShoppingCarContract.Model =ShoppingCarModel()
}