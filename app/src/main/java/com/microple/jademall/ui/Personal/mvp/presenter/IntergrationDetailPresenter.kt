package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.IntergrationDetailContract
import com.microple.jademall.ui.Personal.mvp.model.IntergrationDetailModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class IntergrationDetailPresenter:IntergrationDetailContract.Presenter() {
    override fun getDetail(token: String, up_id: String) {
        getModel().getDetail(token,up_id).ui({
            getView()?.getDetail(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): IntergrationDetailContract.Model =IntergrationDetailModel()
}