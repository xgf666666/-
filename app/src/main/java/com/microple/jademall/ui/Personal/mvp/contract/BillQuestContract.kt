package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.PointDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface BillQuestContract {
    interface View :BaseMvpView{
        fun getPoint(pointDetail: PointDetail)

    }
    interface Model{
        fun getPoint(token:String): Observable<BaseResponseEntity<PointDetail>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getPoint(token: String)

    }
}