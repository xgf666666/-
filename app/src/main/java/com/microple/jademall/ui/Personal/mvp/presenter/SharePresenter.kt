package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.ShareContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.ShareModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SharePresenter:ShareContract.Presenter() {
    override fun createModel(): ShareContract.Model =ShareModel()
}