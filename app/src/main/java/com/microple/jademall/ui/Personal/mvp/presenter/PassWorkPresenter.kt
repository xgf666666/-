package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.PassWorkContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.PassWorkModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PassWorkPresenter:PassWorkContract.Presenter() {
    override fun createModel(): PassWorkContract.Model =PassWorkModel()
}