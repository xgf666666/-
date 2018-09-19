package com.microple.jademall.ui.search.mvp.contract

import com.microple.jademall.bean.SearchResult
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable
import java.util.regex.MatchResult

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface SearchResultGoodsContract {
    interface View :BaseMvpView{
        fun getResult(searchResult: SearchResult)


    }
    interface Model{
        fun getResult(keyword:String): Observable<BaseResponseEntity<SearchResult>>



    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
       abstract fun getResult(keyword:String)


    }
}