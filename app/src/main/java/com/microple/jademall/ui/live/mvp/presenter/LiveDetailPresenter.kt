package com.microple.jademall.ui.live.mvp.presenter

import com.microple.jademall.ui.live.mvp.contract.LiveDetailContract
import com.microple.jademall.ui.live.mvp.model.LiveDetailModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LiveDetailPresenter:LiveDetailContract.Presenter() {
    override fun liveYuyue(token: String, live_id: String) {
        getModel().liveYuyue(token,live_id).ui({
            getView()?.liveYuyue(it.msg!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun getDetail(token: String, live_id: String) {
        getModel().getDetail(token,live_id).ui({
            getView()?.getDetail(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): LiveDetailContract.Model =LiveDetailModel()
}