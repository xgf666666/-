package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.NotGoodsOrderContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.NotGoodsOrderModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class NotGoodsOrderPresenter:NotGoodsOrderContract.Presenter() {
    override fun createModel(): NotGoodsOrderContract.Model =NotGoodsOrderModel()
}