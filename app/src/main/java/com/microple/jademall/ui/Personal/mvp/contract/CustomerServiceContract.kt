package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.ServicePhone
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface CustomerServiceContract {
    interface View :BaseMvpView{
        fun getPhone(servicePhone: ServicePhone)

    }
    interface Model{
        fun getPhone(): Observable<BaseResponseEntity<ServicePhone>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getphone()

    }
}