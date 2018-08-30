package com.microple.jademall.ui.home.mvp.contract

import com.microple.jademall.bean.Goods
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface HomeGoodsContract {
    interface View :BaseMvpView{
        fun getGoodList(data:Goods)

    }
    interface Model{
        fun getGoodList(cat_id:Int,page:Int,sort:String): Observable<BaseResponseEntity<Goods>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getGoodList(cat_id:Int,page:Int,sort:String)
    }
}