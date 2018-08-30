package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.home.mvp.contract.HomeGoodsContract
import com.microple.jademall.ui.home.mvp.model.GoodsDetailModel
import com.microple.jademall.ui.home.mvp.model.HomeGoodsModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class GoodsDetailPresenter:GoodsDetailContract.Presenter() {
    override fun getLabel(label_id: String) {
        getModel().getLabel(label_id).ui({
            getView()?.getLabel(it.data?.label?.label_desc!!)

        },{
            getView()?.showToast(it.message)
        })
    }

    override fun getDetail(goods_sn: String) {
        getModel().getDetail(goods_sn).ui({
                getView()?.getDetail(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): GoodsDetailContract.Model =GoodsDetailModel()
}