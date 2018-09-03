package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.BillQuestContract
import com.microple.jademall.ui.Personal.mvp.model.BillQuestModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class BillQuestPresenter:BillQuestContract.Presenter() {
    override fun getPoint(token: String) {
        getModel().getPoint(token).ui({
            getView()?.getPoint(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): BillQuestContract.Model =BillQuestModel()
}