package com.microple.jademall.ui.Personal.mvp.presenter

import android.text.TextUtils
import com.microple.jademall.ui.Personal.mvp.contract.BindPhoneContract
import com.microple.jademall.ui.Personal.mvp.model.BindPhoneModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class BindPhonePresenter:BindPhoneContract.Presenter() {

    override fun getCode(phone: String) {
        if (TextUtils.isEmpty(phone)){
            getView()?.showToast("请输入手机号")
            getView()?.dismissLoadingDialog()
            return
        }else if (11!=phone.length){
            getView()?.dismissLoadingDialog()
            getView()?.showToast("请输入正确的手机号")
            return
        }
        getModel().getCode(phone).ui({
            getView()?.getCode()
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it.message)
        })
    }

    override fun bindPhone(openid: String, phone: String, phone_code: String, code: String,nickname	:String,head_img:String) {
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
        getModel().bindPhone(openid,phone,phone_code,code,nickname,head_img).ui({
            getView()?.bindPhone(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }
    override fun getInfo(token: String) {
        getModel().getInfo(token).ui({
            getView()?.getInfo(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun createModel(): BindPhoneContract.Model =BindPhoneModel()
}