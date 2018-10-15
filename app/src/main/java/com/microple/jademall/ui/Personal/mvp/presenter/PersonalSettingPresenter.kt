package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.PersonalSettingContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.PersonalSettingModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PersonalSettingPresenter:PersonalSettingContract.Presenter() {
    override fun setHandImageView(token: String, head_img: String) {
        getModel().setHandImageView(token,head_img).ui({
            getView()?.setHandImageView(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): PersonalSettingContract.Model =PersonalSettingModel()
}