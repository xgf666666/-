package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionContract
import com.microple.jademall.ui.Personal.mvp.contract.AskQuestionDetailContract
import com.microple.jademall.ui.Personal.mvp.model.AskQuestionDetailModel
import com.microple.jademall.ui.Personal.mvp.model.AskQuestionModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AskQuestionDetailPresenter: AskQuestionDetailContract.Presenter() {
    override fun createModel(): AskQuestionDetailContract.Model =AskQuestionDetailModel()
}