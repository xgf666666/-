package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Record
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface MerchantEntryRecordContract {
    interface View :BaseMvpView{
        fun  getRecord(record:Record)

    }
    interface Model{
        fun getRecord(token:String): Observable<BaseResponseEntity<Record>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
       abstract fun getRecord(token:String)

    }
}