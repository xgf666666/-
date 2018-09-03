package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.AskDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface AskQuestionDetailContract {
    interface View :BaseMvpView{
        fun getDetail(askDetail: AskDetail)

    }
    interface Model{
        fun getDetail(pt_id:String): Observable<BaseResponseEntity<AskDetail>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getDetail(pt_id:String)

    }
}