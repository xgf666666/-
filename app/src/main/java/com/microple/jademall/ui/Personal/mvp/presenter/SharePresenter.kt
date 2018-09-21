package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.ShareContract
import com.microple.jademall.ui.Personal.mvp.model.ShareModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SharePresenter:ShareContract.Presenter() {
    override fun getShare(token: String) {
        getModel().getShare(token).ui({
            getView()?.getShare(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): ShareContract.Model =ShareModel()
}