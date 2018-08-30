package com.microple.jademall.ui.Personal.mvp.presenter

import android.text.TextUtils
import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.microple.jademall.ui.Personal.mvp.contract.NickNameContract
import com.microple.jademall.ui.Personal.mvp.model.AddressModel
import com.microple.jademall.ui.Personal.mvp.model.NickNameModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class NickNamePresenter:NickNameContract.Presenter() {
    override fun setNickName(token: String, nickname: String) {
        if (TextUtils.isEmpty(nickname)){
            getView()?.showToast("请输入昵称")
            return
        }
        getModel().setNickName(token,nickname).ui({
            if (it.status.equals("1"))
                getView()?.showToast(it.msg)
            getView()?.setNickName()
        },{
                getView()?.showToast(it)
        })

    }

    override fun createModel(): NickNameContract.Model =NickNameModel()
}