package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Address
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface AddressContract {
    interface View :BaseMvpView{
       fun getAddress(address: Address)
        fun setAddress(msg:String)

    }
    interface Model{
        fun getAddress(token:String): Observable<BaseResponseEntity<Address>>
        fun delAddress(token:String,address_id:String):Observable<BaseResponseEntity<Any>>
        fun settingAddress(token:String,address_id:String):Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
       abstract fun getAddress(token:String)
        abstract  fun delAddress(token:String,address_id:String)
        abstract  fun settingAddress(token:String,address_id:String)
    }
}