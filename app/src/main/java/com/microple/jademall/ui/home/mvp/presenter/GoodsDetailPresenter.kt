package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.home.mvp.contract.HomeGoodsContract
import com.microple.jademall.ui.home.mvp.model.GoodsDetailModel
import com.microple.jademall.ui.home.mvp.model.HomeGoodsModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class GoodsDetailPresenter:GoodsDetailContract.Presenter() {
    override fun createModel(): GoodsDetailContract.Model =GoodsDetailModel()
}