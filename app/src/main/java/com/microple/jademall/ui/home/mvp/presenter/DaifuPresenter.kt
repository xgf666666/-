package com.microple.jademall.ui.home.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.home.mvp.contract.DaifuContract
import com.microple.jademall.ui.home.mvp.model.DaifuModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class DaifuPresenter:DaifuContract.Presenter() {
    override fun daifu(token: String, sb_id: String, send: String, freight_pay: String, live: String, cabinet: String, incr_type1: String, incr_type2: String, incr_type3: String, address_id: String, phone: String, pay_msg: String) {
        getView()?.showLoadingDialog()
        getModel()?.daifu(token,sb_id,send,freight_pay,live,cabinet,incr_type1,incr_type2,incr_type3,address_id,phone,pay_msg).ui({
            getView()?.daifu()
            getView()?.dismissLoadingDialog()
        },{
            getView()?.showToast(it.message)
            getView()?.dismissLoadingDialog()
        })
    }

    override fun createModel(): DaifuContract.Model =DaifuModel()
}