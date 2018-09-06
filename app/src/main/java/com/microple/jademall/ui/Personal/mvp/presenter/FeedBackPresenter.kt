package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.FeedBackContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.FeedBackModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class FeedBackPresenter:FeedBackContract.Presenter() {
    override fun getContent(token: String, content: String) {
        if (content.isNullOrEmpty()){
            getView()?.showToast("请输入反馈内容")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().getContent(token,content).ui({
            getView()?.getContent(it.msg!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): FeedBackContract.Model =FeedBackModel()
}