package com.microple.jademall.ui.search.mvp.model

import com.microple.jademall.bean.GoodsDetail
import com.microple.jademall.bean.Search
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.search.mvp.contract.SearchContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SeachModel: SearchContract.Model {
    override fun getSearch(): Observable<BaseResponseEntity<Search>> =AppApi.Api().setSearch()

}