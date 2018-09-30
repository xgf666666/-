package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.ImageDetailContract
import com.microple.jademall.ui.home.mvp.model.ImageDetailModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ImageDetailPresenter:ImageDetailContract.Presenter() {
    override fun getImgageDetail(goods_id: String) {
        getModel().getImageDetail(goods_id).ui({
            getView()?.getImageDetail(it?.data?.goods?.goods_content!!)

        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): ImageDetailContract.Model =ImageDetailModel()
}