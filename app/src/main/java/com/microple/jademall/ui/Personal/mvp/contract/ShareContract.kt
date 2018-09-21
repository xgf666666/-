package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Share
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface ShareContract {
    interface View :BaseMvpView{
        fun getShare(share:Share)
    }
    interface Model{
        fun getShare(token:String): Observable<BaseResponseEntity<Share>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getShare(token: String)

    }
}