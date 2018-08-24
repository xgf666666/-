package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.OrderDetailContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.OrderDetailModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class OrderDetailPresenter:OrderDetailContract.Presenter() {
    override fun createModel(): OrderDetailContract.Model =OrderDetailModel()
}