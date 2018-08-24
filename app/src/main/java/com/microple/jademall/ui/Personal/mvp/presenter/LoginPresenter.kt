package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.LoginContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.LoginModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LoginPresenter:LoginContract.Presenter() {
    override fun createModel(): LoginContract.Model =LoginModel()
}