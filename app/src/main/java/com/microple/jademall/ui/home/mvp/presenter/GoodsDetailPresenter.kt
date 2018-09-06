package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.home.mvp.contract.HomeGoodsContract
import com.microple.jademall.ui.home.mvp.model.GoodsDetailModel
import com.microple.jademall.ui.home.mvp.model.HomeGoodsModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class GoodsDetailPresenter:GoodsDetailContract.Presenter() {
    override fun addShoping(token: String, goods_id: String) {
        getModel().addShoping(token,goods_id).ui({
            getView()?.addShoping()
        },{
            getView()?.showToast(it)
        })
    }

    override fun collection(token: String, goods_id: String) {
        getModel().collection(token,goods_id).ui({
            getView()?.collection(it.msg!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun getLabel(label_id: String) {
        getModel().getLabel(label_id).ui({
            getView()?.getLabel(it.data?.label?.label_desc!!)

        },{
            getView()?.showToast(it.message)
        })
    }

    override fun getDetail(token:String,goods_sn: String) {
        getModel().getDetail(token,goods_sn).ui({
                getView()?.getDetail(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): GoodsDetailContract.Model =GoodsDetailModel()
}