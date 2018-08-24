package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.EmeraldsContract
import com.microple.jademall.ui.Personal.mvp.model.EmeraldsModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class EmeraldsPresenter:EmeraldsContract.Presenter() {
    override fun createModel(): EmeraldsContract.Model =EmeraldsModel()
}