package com.microple.jademall.ui.search.mvp.model

import com.microple.jademall.bean.Category
import com.microple.jademall.bean.GoodsDetail
import com.microple.jademall.bean.TwoSearch
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.search.mvp.contract.SearchContract
import com.microple.jademall.ui.search.mvp.contract.SearchSortGoodsContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SearchSortGoodsModel: SearchSortGoodsContract.Model {
    override fun getCategory(cat_id:String): Observable<BaseResponseEntity<TwoSearch>> =AppApi.Api().cateSearch(cat_id)


}