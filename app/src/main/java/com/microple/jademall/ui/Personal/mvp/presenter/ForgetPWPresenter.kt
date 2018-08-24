package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.ForgetPWContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.ForgetPWModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ForgetPWPresenter:ForgetPWContract.Presenter() {
    override fun createModel(): ForgetPWContract.Model =ForgetPWModel()
}