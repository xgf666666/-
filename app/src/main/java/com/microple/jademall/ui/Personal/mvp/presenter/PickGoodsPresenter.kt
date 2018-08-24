package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.PickGoodsContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.PickGoodsModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PickGoodsPresenter:PickGoodsContract.Presenter() {
    override fun createModel(): PickGoodsContract.Model =PickGoodsModel()
}