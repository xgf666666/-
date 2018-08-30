package com.microple.jademall.ui.search.mvp.contract

import com.microple.jademall.bean.Category
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface SearchSortGoodsContract {
    interface View :BaseMvpView{
        fun getCategory(data:List<Category>)


    }
    interface Model{
        fun getCategory(): Observable<BaseResponseEntity<List<Category>>>


    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getCategory()


    }
}