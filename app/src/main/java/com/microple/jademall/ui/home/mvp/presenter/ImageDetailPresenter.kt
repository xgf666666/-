package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.ImageDetailContract
import com.microple.jademall.ui.home.mvp.model.ImageDetailModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ImageDetailPresenter:ImageDetailContract.Presenter() {
    override fun createModel(): ImageDetailContract.Model =ImageDetailModel()
}