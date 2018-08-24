package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.HomeContract
import com.microple.jademall.ui.home.mvp.model.HomeModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class HomePresenter:HomeContract.Presenter() {
    override fun createModel(): HomeContract.Model =HomeModel()
}