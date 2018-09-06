package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.NeedNoteContract
import com.microple.jademall.ui.Personal.mvp.model.NeednoteModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class NeedNotePresenter:NeedNoteContract.Presenter() {
    override fun getNoteContent(token: String) {
        getModel().getNoteContent(token).ui({
            getView()?.getNoteContent(it.data?.enter_protocol?.value!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): NeedNoteContract.Model =NeednoteModel()
}