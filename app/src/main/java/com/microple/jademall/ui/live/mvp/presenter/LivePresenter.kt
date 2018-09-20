package com.microple.jademall.ui.live.mvp.presenter

import com.microple.jademall.ui.live.mvp.contract.LiveContract
import com.microple.jademall.ui.live.mvp.model.LiveModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LivePresenter:LiveContract.Presenter() {
    override fun liveList(token: String) {
        getModel().liveList(token).ui({
            getView()?.liveList(it.data!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): LiveContract.Model =LiveModel()
}