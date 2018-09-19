package com.microple.jademall.ui.search.mvp.model

import com.microple.jademall.bean.GoodsDetail
import com.microple.jademall.bean.SearchResult
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.search.mvp.contract.SearchContract
import com.microple.jademall.ui.search.mvp.contract.SearchResultGoodsContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SeachResultGoodsModel: SearchResultGoodsContract.Model {
    override fun getResult(keyword: String): Observable<BaseResponseEntity<SearchResult>> =AppApi.Api().getResult(keyword)

}