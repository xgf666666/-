package com.microple.jademall.ui.Personal.mvp.contract

import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface PickGoodsContract {
    interface View :BaseMvpView{

    }
    interface Model{

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){

    }
}