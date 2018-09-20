package com.microple.jademall.ui.live.mvp.contract

import com.microple.jademall.bean.LiveList
import com.microple.jademall.bean.LiveShare
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface LivePlayerContract {
    interface View :BaseMvpView{
        fun liveShare(liveShare: LiveShare)

    }
    interface Model{
        fun liveShare(live_id: String): Observable<BaseResponseEntity<LiveShare>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun liveShare(live_id: String)
    }
}