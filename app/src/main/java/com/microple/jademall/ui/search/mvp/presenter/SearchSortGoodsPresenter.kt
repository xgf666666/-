package com.microple.jademall.ui.search.mvp.presenter

import android.view.SearchEvent
import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.home.mvp.contract.HomeGoodsContract
import com.microple.jademall.ui.home.mvp.model.GoodsDetailModel
import com.microple.jademall.ui.home.mvp.model.HomeGoodsModel
import com.microple.jademall.ui.search.mvp.contract.SearchContract
import com.microple.jademall.ui.search.mvp.contract.SearchSortGoodsContract
import com.microple.jademall.ui.search.mvp.model.SeachModel
import com.microple.jademall.ui.search.mvp.model.SearchSortGoodsModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SearchSortGoodsPresenter:SearchSortGoodsContract.Presenter() {
    override fun getCategory(cat_id:String) {
        getModel().getCategory(cat_id).ui({
            getView()?.getCategory(it.data!!)
        },{
            getView()?.showToast(it.message)
        })

    }


    override fun createModel(): SearchSortGoodsContract.Model =SearchSortGoodsModel()
}