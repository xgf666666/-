package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.BillQuestContract
import com.microple.jademall.ui.Personal.mvp.model.BillQuestModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class BillQuestPresenter:BillQuestContract.Presenter() {
    override fun createModel(): BillQuestContract.Model =BillQuestModel()
}