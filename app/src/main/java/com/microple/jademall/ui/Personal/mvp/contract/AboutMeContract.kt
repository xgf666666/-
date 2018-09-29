package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.AboutMe
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface AboutMeContract {
    interface View :BaseMvpView{
         fun aboutMe(aboutMe: AboutMe)

    }
    interface Model{
        fun aboutMe(): Observable<BaseResponseEntity<AboutMe>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun aboutMe()

    }
}