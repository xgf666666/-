package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.MessageDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface MessageDetailContract {
    interface View :BaseMvpView{
       fun getMessageDetail(messageDetail: MessageDetail)


    }
    interface Model{
        fun getMessageDetail(token:String,msg_id:String): Observable<BaseResponseEntity<MessageDetail>>


    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getMessageDetail(token: String,msg_id:String)


    }
}