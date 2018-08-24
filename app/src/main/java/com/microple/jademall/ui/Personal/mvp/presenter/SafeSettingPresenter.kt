package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.SafeSettingContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.SafeSettingModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SafeSettingPresenter:SafeSettingContract.Presenter() {
    override fun createModel(): SafeSettingContract.Model =SafeSettingModel()
}