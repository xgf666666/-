package com.microple.jademall.ui.home.mvp.contract

import com.microple.jademall.bean.Category
import com.microple.jademall.bean.FirstImage
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
interface HomeContract {
    interface View :BaseMvpView{
        fun getFirstView(data:List<FirstImage>)
        fun getCategory(data:List<Category>)
        fun getGoodList(data:Goods)

    }
    interface Model{
        fun getFirstView(): Observable<BaseResponseEntity<List<FirstImage>>>
        fun getCategory(): Observable<BaseResponseEntity<List<Category>>>
        fun getGoodList(cat_id:Int,page:Int,sort:String): Observable<BaseResponseEntity<Goods>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getFirstView()
        abstract fun getCategory()
        abstract fun getGoodList(cat_id:Int,page:Int,sort:String)

    }
}