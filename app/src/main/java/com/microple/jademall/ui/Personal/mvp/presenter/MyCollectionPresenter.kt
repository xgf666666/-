package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AllOrderContract
import com.microple.jademall.ui.Personal.mvp.contract.MyCollectionContract
import com.microple.jademall.ui.Personal.mvp.model.AllOrderModel
import com.microple.jademall.ui.Personal.mvp.model.MyCollectionModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyCollectionPresenter:MyCollectionContract.Presenter() {
    override fun createModel(): MyCollectionContract.Model =MyCollectionModel()
}