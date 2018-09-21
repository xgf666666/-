package com.microple.jademall.ui.Personal.mvp.presenter

import android.text.TextUtils
import com.microple.jademall.ui.Personal.mvp.contract.RegisterContract
import com.microple.jademall.ui.Personal.mvp.model.RegisterModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class RegisterPresenter:RegisterContract.Presenter() {
    override fun register(phone: String, phone_code: String, pwd: String, pwds: String, code: String) {
        if (TextUtils.isEmpty(phone)){
            getView()?.showToast("请输入手机号")
            getView()?.dismissLoadingDialog()
            return
        }else if (11!=phone.length){
            getView()?.showToast("请输入正确的手机号")
            getView()?.dismissLoadingDialog()
            return
        }
        if (TextUtils.isEmpty(phone_code)){
            getView()?.showToast("请输入验证码")
            getView()?.dismissLoadingDialog()
            return
        }else if (6!=phone_code.length){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (TextUtils.isEmpty(pwd)||pwd.length<6||pwd.length>16){
            getView()?.showToast("请输入6到16位密码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (TextUtils.isEmpty(pwds)){
            getView()?.showToast("请输入确认密码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (pwd!=pwds){
            getView()?.showToast("请输入相同的密码")
            getView()?.dismissLoadingDialog()
            return

        }


        getModel().register(phone,phone_code,pwd,pwds,code).ui({
                getView()?.register()

        },{
            getView()?.showToast(it.message)
        })
    }

    override fun getCode(phone: String) {
        if (TextUtils.isEmpty(phone)){
            getView()?.showToast("请输入手机号")
            getView()?.dismissLoadingDialog()
            return
        }else if (11!=phone.length){
            getView()?.showToast("请输入正确的手机号")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().getCode(phone).ui({
            if (it.status.equals("1")){
                getView()?.getCode("")
                getView()?.showToast(it.msg)
            }
        },{
        })
    }

    override fun createModel(): RegisterContract.Model =RegisterModel()
}