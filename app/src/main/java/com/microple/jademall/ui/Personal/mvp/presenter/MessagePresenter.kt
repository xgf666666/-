package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.MessageContract
import com.microple.jademall.ui.Personal.mvp.model.MessageModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MessagePresenter:MessageContract.Presenter() {
    override fun createModel(): MessageContract.Model =MessageModel()
}