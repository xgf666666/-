package com.microple.jademall.ui.shoppingcar.mvp.contract

import com.microple.jademall.bean.Shop
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface ShoppingCarContract {
    interface View :BaseMvpView{
        fun shop(shop: Shop)
        fun delShop()
        fun updateShop(shop: Shop)

    }
    interface Model{
        fun shop(token:String): Observable<BaseResponseEntity<Shop>>
        fun delShop(token:String,sb_id:String):Observable<BaseResponseEntity<Any>>
        fun updateShop(token:String):Observable<BaseResponseEntity<Shop>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun shop(token:String)
        abstract fun delShop(token:String,sb_id:String)
        abstract fun updateShop(token:String)

    }
}