package com.microple.jademall.ui.live.mvp.contract

import com.microple.jademall.bean.LiveDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface LiveDetailContract {
    interface View :BaseMvpView{
        fun getDetail(liveDetail: LiveDetail)
        fun liveYuyue(msg:String)

    }
    interface Model{
        fun getDetail(token:String,live_id:String): Observable<BaseResponseEntity<LiveDetail>>
        fun liveYuyue(token:String,live_id:String):Observable<BaseResponseEntity<Any>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getDetail(token:String,live_id:String)
        abstract fun liveYuyue(token:String,live_id:String)

    }
}