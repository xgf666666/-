package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Pick
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface PickGoodsContract {
    interface View :BaseMvpView{
        fun pick(pick:Pick)

    }
    interface Model{
        fun pick(token:String,ct_id:String): Observable<BaseResponseEntity<Pick>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun pick(token:String,ct_id:String)
    }
}