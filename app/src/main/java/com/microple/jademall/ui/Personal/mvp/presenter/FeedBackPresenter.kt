package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.FeedBackContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.FeedBackModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class FeedBackPresenter:FeedBackContract.Presenter() {
    override fun createModel(): FeedBackContract.Model =FeedBackModel()
}