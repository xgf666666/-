package com.microple.jademall.ui.home.mvp.model

import com.microple.jademall.bean.Category
import com.microple.jademall.bean.FirstImage
import com.microple.jademall.bean.Goods
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.home.mvp.contract.HomeContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class HomeModel: HomeContract.Model {
    override fun getCategory(): Observable<BaseResponseEntity<List<Category>>> =
            AppApi.Api().getCategory()
    override fun getGoodList(cat_id: Int, page: Int, sort: String): Observable<BaseResponseEntity<Goods>> =
            AppApi.Api().getGoodList(cat_id,page,sort)



    override fun getFirstView(): Observable<BaseResponseEntity<List<FirstImage>>> =AppApi.Api().getFirstImage()

}