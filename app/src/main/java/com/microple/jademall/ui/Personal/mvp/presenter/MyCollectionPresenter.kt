package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AllOrderContract
import com.microple.jademall.ui.Personal.mvp.contract.MyCollectionContract
import com.microple.jademall.ui.Personal.mvp.model.AllOrderModel
import com.microple.jademall.ui.Personal.mvp.model.MyCollectionModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyCollectionPresenter:MyCollectionContract.Presenter() {
    override fun getzujiList(token: String) {
        getModel().getzujiList(token).ui({
            getView()?.getCollection(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun getCollection(token: String) {
        getModel().getCollection(token).ui({
            getView()?.getCollection(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): MyCollectionContract.Model =MyCollectionModel()
}