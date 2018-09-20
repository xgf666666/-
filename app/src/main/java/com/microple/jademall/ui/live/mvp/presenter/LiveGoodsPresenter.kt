package com.microple.jademall.ui.live.mvp.presenter

import com.microple.jademall.ui.live.mvp.contract.LiveGoodsContract
import com.microple.jademall.ui.live.mvp.model.LiveGoodsModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LiveGoodsPresenter:LiveGoodsContract.Presenter() {
    override fun getGoods(live_id: String) {
        getModel().getGoods(live_id).ui({
            getView()?.getGoods(it.data!!)
        },{
           getView()?.showToast(it.message)
        })
    }

    override fun createModel(): LiveGoodsContract.Model =LiveGoodsModel()
}