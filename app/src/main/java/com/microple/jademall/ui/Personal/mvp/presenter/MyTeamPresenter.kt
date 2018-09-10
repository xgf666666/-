package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MyTeamContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.MyTeamModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyTeamPresenter:MyTeamContract.Presenter() {
    override fun team(token: String, user_id: String) {
        getModel()?.team(token, user_id).ui({
            getView()?.team(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun createModel(): MyTeamContract.Model =MyTeamModel()
}