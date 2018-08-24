package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MyAppointmentContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.MyAppointmentModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyAppointmentPresenter:MyAppointmentContract.Presenter() {
    override fun createModel(): MyAppointmentContract.Model =MyAppointmentModel()
}