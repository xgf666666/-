package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.microple.jademall.ui.Personal.mvp.contract.TeamTwoContract
import com.microple.jademall.ui.Personal.mvp.model.AddressModel
import com.microple.jademall.ui.Personal.mvp.model.TeamTwoModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class TeamTwoPresenter:TeamTwoContract.Presenter() {
    override fun createModel(): TeamTwoContract.Model =TeamTwoModel()
}