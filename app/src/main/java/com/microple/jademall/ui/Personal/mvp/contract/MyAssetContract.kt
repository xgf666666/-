package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Assert
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface MyAssetContract {
    interface View :BaseMvpView{
        fun getMyAssert(assert: Assert)

    }
    interface Model{
        fun getMyAssert(token:String): Observable<BaseResponseEntity<Assert>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract  fun getMyAssert(token:String)
    }
}