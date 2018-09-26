package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MyAppointmentContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.MyAppointmentModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyAppointmentPresenter:MyAppointmentContract.Presenter() {
    override fun exitAppoint(token: String, live_id: String) {
        getModel().exitAppoint(token,live_id).ui({
            getView()?.exitAppoint(it.msg!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun myAppoint(token: String) {
        getModel().myAppoint(token).ui({
            getView()?.myAppoint(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): MyAppointmentContract.Model =MyAppointmentModel()
}