package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.AskType
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface AskQuestionTypeContract {
    interface View :BaseMvpView{
       fun getType(askType: AskType)

    }
    interface Model{
        fun getType(): Observable<BaseResponseEntity<AskType>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getType()

    }
}