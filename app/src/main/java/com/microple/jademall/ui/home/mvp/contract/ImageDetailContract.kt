package com.microple.jademall.ui.home.mvp.contract

import com.microple.jademall.bean.ImageDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface ImageDetailContract {
    interface View :BaseMvpView{
        fun getImageDetail(goods_content:String)

    }
    interface Model{
        fun getImageDetail(goods_id:String): Observable<BaseResponseEntity<ImageDetail>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getImgageDetail(goods_id:String)

    }
}