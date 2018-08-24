package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MerchanEntryContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.MerchanEntryModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MerchanEntryPresenter:MerchanEntryContract.Presenter() {
    override fun createModel(): MerchanEntryContract.Model =MerchanEntryModel()
}