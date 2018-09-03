package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionContract
import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionTypeContract
import com.microple.jademall.ui.Personal.mvp.model.AskQuestionModel
import com.microple.jademall.ui.Personal.mvp.model.AskQuestionTypeModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AskQuestionTypePresenter:AskQuestionTypeContract.Presenter() {
    override fun getType() {
        getModel().getType().ui({
            getView()?.getType(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): AskQuestionTypeContract.Model =AskQuestionTypeModel()
}