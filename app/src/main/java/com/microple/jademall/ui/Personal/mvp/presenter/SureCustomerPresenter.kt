package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.SureCustomerContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.SureCustomerModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SureCustomerPresenter:SureCustomerContract.Presenter() {
    override fun apply(token: String, order_id: String, goods_id: String, reason: String, desc: String, refunds: String) {
        if (reason.isNullOrEmpty()){
            getView()?.showToast("请选择退货理由")
            getView()?.dismissLoadingDialog()
            return
        }

        getModel().apply(token,order_id,goods_id,reason,desc,refunds).ui({
            getView()?.apply()
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): SureCustomerContract.Model =SureCustomerModel()
}