package com.microple.jademall.ui.Personal.mvp.contract

import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface NickNameContract {
    interface View :BaseMvpView{
        fun setNickName()

    }
    interface Model{
        fun setNickName(token:String,nickname:String): Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
       abstract fun setNickName(token:String,nickname:String)

    }
}