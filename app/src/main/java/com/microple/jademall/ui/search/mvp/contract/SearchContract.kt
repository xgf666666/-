package com.microple.jademall.ui.search.mvp.contract

import com.microple.jademall.bean.Search
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface SearchContract {
    interface View :BaseMvpView{
        fun getSearch(data:Search)


    }
    interface Model{
        fun getSearch(): Observable<BaseResponseEntity<Search>>


    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getSearch()
    }
}