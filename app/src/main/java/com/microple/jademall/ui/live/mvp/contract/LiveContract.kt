package com.microple.jademall.ui.live.mvp.contract

import com.microple.jademall.bean.LiveList
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface LiveContract {
    interface View :BaseMvpView{
        fun liveList(liveList: LiveList)

    }
    interface Model{
        fun liveList(token: String): Observable<BaseResponseEntity<LiveList>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun liveList(token: String)
    }
}