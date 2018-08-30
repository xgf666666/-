package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.PersonalContract
import com.microple.jademall.ui.Personal.mvp.model.PersonalModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PersonalPresenter:PersonalContract.Presenter() {
    override fun getInfo(token: String) {
        getModel().getInfo(token).ui({
            getView()?.getInfo(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun createModel(): PersonalContract.Model =PersonalModel()
}