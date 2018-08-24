package com.microple.jademall.ui.live.mvp.presenter

import com.microple.jademall.ui.live.mvp.contract.LiveDetailContract
import com.microple.jademall.ui.live.mvp.model.LiveDetailModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LiveDetailPresenter:LiveDetailContract.Presenter() {
    override fun createModel(): LiveDetailContract.Model =LiveDetailModel()
}