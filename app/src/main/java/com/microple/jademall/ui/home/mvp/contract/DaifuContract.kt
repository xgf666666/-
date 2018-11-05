package com.microple.jademall.ui.home.mvp.contract

import com.microple.jademall.bean.AboutMe
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface DaifuContract {
    interface View :BaseMvpView{
        fun daifu()

    }
    interface Model{
        fun  daifu(token:String,sb_id:String,send:String,freight_pay:String,live:String,cabinet:String,incr_type1:String,incr_type2:String,incr_type3:String,address_id:String,phone:String,pay_msg:String):Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract   fun  daifu(token:String,sb_id:String,send:String,freight_pay:String,live:String,cabinet:String,incr_type1:String,incr_type2:String,incr_type3:String,address_id:String,phone:String,pay_msg:String)

    }
}