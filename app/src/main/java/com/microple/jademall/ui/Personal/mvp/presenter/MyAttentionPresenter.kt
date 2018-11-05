package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MyAttentionContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.MyAttentionModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyAttentionPresenter:MyAttentionContract.Presenter() {
    override fun getAttention() {
        getView()?.showLoadingDialog()
        getModel().getAttention(Constants.getToken()).ui({
            getView()?.getAttention(it.data!!)
            getView()?.dismissLoadingDialog()
        },{
            getView()?.showToast(it.message)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun createModel(): MyAttentionContract.Model =MyAttentionModel()
}