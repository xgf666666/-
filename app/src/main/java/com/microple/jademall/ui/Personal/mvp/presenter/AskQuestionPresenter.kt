package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionContract
import com.microple.jademall.ui.Personal.mvp.model.AskQuestionModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AskQuestionPresenter:AskQuestionContract.Presenter() {
    override fun createModel(): AskQuestionContract.Model =AskQuestionModel()
}