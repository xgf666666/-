package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Note
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface NeedNoteContract {
    interface View :BaseMvpView{
        fun getNoteContent(value:String)

    }
    interface Model{
        fun getNoteContent(token:String): Observable<BaseResponseEntity<Note>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getNoteContent(token:String)
    }
}