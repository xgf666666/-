package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.HomeGoodsContract
import com.microple.jademall.ui.home.mvp.model.HomeGoodsModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class HomeGoodsPresenter:HomeGoodsContract.Presenter() {
    override fun createModel(): HomeGoodsContract.Model =HomeGoodsModel()
    override fun getGoodList(cat_id: Int, page: Int, sort: String) {
        getModel().getGoodList(cat_id,page,sort).ui({
            getView()?.getGoodList(it.data!!)

        },{
            getView()?.showToast(it.message)

        })
    }
}