package com.microple.jademall.ui.live.mvp.presenter

import com.microple.jademall.ui.live.mvp.contract.LiveContract
import com.microple.jademall.ui.live.mvp.contract.LivePlayerContract
import com.microple.jademall.ui.live.mvp.model.LiveModel
import com.microple.jademall.ui.live.mvp.model.LivePlayerModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LivePlayerPresenter:LivePlayerContract.Presenter() {
    override fun liveShare(live_id: String) {
        getModel().liveShare(live_id).ui({
            getView()?.liveShare(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun createModel(): LivePlayerContract.Model =LivePlayerModel()
}