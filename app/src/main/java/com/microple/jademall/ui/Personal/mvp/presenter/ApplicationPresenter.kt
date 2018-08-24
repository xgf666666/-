package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.ApplicationContract
import com.microple.jademall.ui.Personal.mvp.model.ApplicationModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ApplicationPresenter:ApplicationContract.Presenter() {
    override fun createModel(): ApplicationContract.Model =ApplicationModel()
}