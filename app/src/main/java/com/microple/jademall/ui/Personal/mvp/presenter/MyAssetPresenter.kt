package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.ForgetPWContract
import com.microple.jademall.ui.Personal.mvp.contract.MyAssetContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.ForgetPWModel
import com.microple.jademall.ui.Personal.mvp.model.MyAssetModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyAssetPresenter:MyAssetContract.Presenter() {
    override fun createModel(): MyAssetContract.Model =MyAssetModel()
}