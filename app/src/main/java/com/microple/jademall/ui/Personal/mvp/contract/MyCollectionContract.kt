package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Collection
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface MyCollectionContract {
    interface View :BaseMvpView{
        fun getCollection(collection:Collection)

    }
    interface Model{
        fun getCollection(token:String): Observable<BaseResponseEntity<Collection>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getCollection(token: String)

    }
}