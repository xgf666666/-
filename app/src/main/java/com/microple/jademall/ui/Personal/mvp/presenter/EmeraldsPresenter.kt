package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.bean.Emeralds
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.EmeraldsContract
import com.microple.jademall.ui.Personal.mvp.model.EmeraldsModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class EmeraldsPresenter:EmeraldsContract.Presenter() {
    override fun getEmeralds(token: String) {
        getModel().getEmeralds(token).ui({
            getView()?.getEmeralds(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }


    override fun createModel(): EmeraldsContract.Model =EmeraldsModel()
}