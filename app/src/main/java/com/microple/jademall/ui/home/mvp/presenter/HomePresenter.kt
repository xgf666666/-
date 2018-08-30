package com.microple.jademall.ui.home.mvp.presenter

import android.util.Log
import com.microple.jademall.ui.home.mvp.contract.HomeContract
import com.microple.jademall.ui.home.mvp.model.HomeModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class HomePresenter:HomeContract.Presenter() {
    override fun getCategory() {
        getModel().getCategory().ui({
            getView()?.getCategory(it.data!!)

        },{
            getView()?.showToast(it.message)

        })

    }



    override fun getFirstView() {
        getModel().getFirstView().ui({
            getView()?.getFirstView(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): HomeContract.Model =HomeModel()
}