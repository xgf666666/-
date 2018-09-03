package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.HandImage
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface PersonalSettingContract {
    interface View :BaseMvpView{
        fun setHandImageView(url:String)

    }
    interface Model{
        fun setHandImageView(token:String,head_img:String): Observable<BaseResponseEntity<HandImage>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun setHandImageView(token:String,head_img:String)

    }
}