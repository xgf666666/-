package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Record
import com.microple.jademall.bean.RecordDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface MerchanEntryRecordDetailContract {
    interface View :BaseMvpView{
        fun getRecordDetail(record: RecordDetail)

    }
    interface Model{
        fun getRecordDetail(token:String,supplier_id:String): Observable<BaseResponseEntity<RecordDetail>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getRecordDetail(token: String,supplier_id: String)

    }
}