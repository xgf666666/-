package com.microple.jademall.ui.Personal.mvp.presenter

import android.text.TextUtils
import com.microple.jademall.ui.Personal.activity.ForgetPWActivity
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.ForgetPWContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.ForgetPWModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.bangbang.common.isPhone
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ForgetPWPresenter:ForgetPWContract.Presenter() {

    override fun setPW(phone: String, phoneCode: String, PW: String) {
        if (TextUtils.isEmpty(phone)){
            getView()?.showToast("请输入手机号")
            getView()?.dismissLoadingDialog()
            return
        }else if (11!=phone.length){
            getView()?.showToast("请输入正确的手机号")
            getView()?.dismissLoadingDialog()
            return
        }
        if (TextUtils.isEmpty(phoneCode)){
            getView()?.showToast("请输入验证码")
            getView()?.dismissLoadingDialog()
            return
        }else if (6!=phoneCode.length){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (TextUtils.isEmpty(PW)||PW.length<6||PW.length>16){
            getView()?.showToast("请输入6到16位密码")
            getView()?.dismissLoadingDialog()
            return
        }

        getModel().setPW(phone,phoneCode,PW).ui({
                getView()?.setPW()
                getView()?.showToast(it.msg)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })

    }

    override fun getCode(phone: String) {
        if (TextUtils.isEmpty(phone)){
            getView()?.showToast("请输入手机号")
            getView()?.dismissLoadingDialog()
            return
        }else if (11!=phone.length||!phone.isPhone()){
            getView()?.showToast("请输入正确的手机号")
           getView()?.dismissLoadingDialog()
            return
        }
        getModel().getCode(phone).ui({
                getView()?.getCode()
                getView()?.showToast(it.msg)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): ForgetPWContract.Model =ForgetPWModel()
}