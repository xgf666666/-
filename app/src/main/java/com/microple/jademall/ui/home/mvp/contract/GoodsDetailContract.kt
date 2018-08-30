package com.microple.jademall.ui.home.mvp.contract

import com.microple.jademall.bean.GoodsDetail
import com.microple.jademall.bean.Label
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface GoodsDetailContract {
    interface View :BaseMvpView{
       fun getDetail(goodsDetail: GoodsDetail)
        fun getLabel(label_desc:String)

    }
    interface Model{
        fun getDetail(goods_sn:String): Observable<BaseResponseEntity<GoodsDetail>>
        fun getLabel(label_id:String):Observable<BaseResponseEntity<Label>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getDetail(goods_sn:String)
        abstract fun getLabel(label_id:String)

    }
}