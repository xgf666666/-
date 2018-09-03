package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionContract
import com.microple.jademall.ui.Personal.mvp.model.AskQuestionModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AskQuestionPresenter:AskQuestionContract.Presenter() {
    override fun getAsk(pt_id: String) {
        getModel().getAsk(pt_id).ui({
            getView()?.getAsk(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): AskQuestionContract.Model =AskQuestionModel()
}