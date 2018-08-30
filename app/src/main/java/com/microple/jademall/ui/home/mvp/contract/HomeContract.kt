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

    }
    interface Model{
        fun getFirstView(): Observable<BaseResponseEntity<List<FirstImage>>>
        fun getCategory(): Observable<BaseResponseEntity<List<Category>>>


    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getFirstView()
        abstract fun getCategory()


    }
}