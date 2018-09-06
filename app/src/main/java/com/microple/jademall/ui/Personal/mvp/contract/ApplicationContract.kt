package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Image
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface ApplicationContract {
    interface View :BaseMvpView{
        fun apply(msg:String)
        fun getImage(image:Image)

    }
    interface Model{
        fun apply(token:String,supplier_name:String,email:String,phone:String,inviter:String,license:String,attach:String): Observable<BaseResponseEntity<Any>>
        fun getImage(upload_img:String):Observable<BaseResponseEntity<Image>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun apply(token:String,supplier_name:String,email:String,phone:String,inviter:String,license:String,attach:String)
        abstract fun getImage(upload_img:String)
    }
}