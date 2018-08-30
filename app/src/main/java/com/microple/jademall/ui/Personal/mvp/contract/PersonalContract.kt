package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.PersonInfo
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface PersonalContract {
    interface View :BaseMvpView{
        fun getInfo(personalInfo: PersonInfo)

    }
    interface Model{
        fun  getInfo(token:String): Observable<BaseResponseEntity<PersonInfo>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getInfo(token: String)

    }
}