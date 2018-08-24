package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.PersonalSettingContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.PersonalSettingModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PersonalSettingPresenter:PersonalSettingContract.Presenter() {
    override fun createModel(): PersonalSettingContract.Model =PersonalSettingModel()
}