package com.microple.jademall.ui.search.mvp.presenter

import com.microple.jademall.ui.search.mvp.contract.SearchContract
import com.microple.jademall.ui.search.mvp.model.SeachModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SearchPresenter:SearchContract.Presenter() {
    override fun getSearch() {
        getModel().getSearch().ui({
            getView()?.getSearch(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }


    override fun createModel(): SearchContract.Model =SeachModel()
}