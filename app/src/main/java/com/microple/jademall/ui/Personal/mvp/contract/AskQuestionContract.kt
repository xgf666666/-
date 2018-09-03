package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Ask
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface AskQuestionContract {
    interface View :BaseMvpView{
        fun getAsk(ask:Ask)

    }
    interface Model{
        fun getAsk(pt_id:String): Observable<BaseResponseEntity<Ask>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getAsk(pt_id:String)

    }
}