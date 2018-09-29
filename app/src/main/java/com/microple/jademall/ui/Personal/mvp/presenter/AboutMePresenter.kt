package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AboutMePresenter:AboutMeContract.Presenter() {
    override fun aboutMe() {
        getModel().aboutMe().ui({
            getView()?.aboutMe(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): AboutMeContract.Model =AboutMelModel()
}