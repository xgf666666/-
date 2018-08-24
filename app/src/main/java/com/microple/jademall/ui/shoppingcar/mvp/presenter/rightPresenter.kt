package com.microple.jademall.ui.shoppingcar.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class rightPresenter:AboutMeContract.Presenter() {
    override fun createModel(): AboutMeContract.Model =AboutMelModel()
}