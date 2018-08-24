package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.microple.jademall.ui.Personal.mvp.contract.NotReviewOrderContract
import com.microple.jademall.ui.Personal.mvp.model.AddressModel
import com.microple.jademall.ui.Personal.mvp.model.NotReviewOrderModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class NotReviewOrderPresenter:NotReviewOrderContract.Presenter() {
    override fun createModel(): NotReviewOrderContract.Model =NotReviewOrderModel()
}