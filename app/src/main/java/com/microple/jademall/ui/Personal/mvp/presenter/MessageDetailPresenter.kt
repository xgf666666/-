package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.MessageDetailContract
import com.microple.jademall.ui.Personal.mvp.model.MessageDetailModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MessageDetailPresenter:MessageDetailContract.Presenter() {
    override fun getMessageDetail(token: String, msg_id: String) {
        getModel().getMessageDetail(token,msg_id).ui({
            getView()?.getMessageDetail(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun createModel(): MessageDetailContract.Model =MessageDetailModel()
}