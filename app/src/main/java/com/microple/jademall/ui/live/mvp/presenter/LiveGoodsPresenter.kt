package com.microple.jademall.ui.live.mvp.presenter

import com.microple.jademall.ui.live.mvp.contract.LiveGoodsContract
import com.microple.jademall.ui.live.mvp.model.LiveGoodsModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LiveGoodsPresenter:LiveGoodsContract.Presenter() {
    override fun createModel(): LiveGoodsContract.Model =LiveGoodsModel()
}