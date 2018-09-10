package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Team
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface MyTeamContract {
    interface View :BaseMvpView{
        fun team(team:Team)

    }
    interface Model{
        fun team(token:String,user_id:String): Observable<BaseResponseEntity<Team>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun team(token: String,user_id:String)

    }
}