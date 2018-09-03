package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.MessageContract
import com.microple.jademall.ui.Personal.mvp.model.MessageModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MessagePresenter:MessageContract.Presenter() {
    override fun getMessage(token: String) {
        getModel().getMessage(token).ui({
            getView()?.getMessage(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun createModel(): MessageContract.Model =MessageModel()
}