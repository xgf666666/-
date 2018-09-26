package com.microple.jademall.ui.Personal.mvp.presenter

import android.text.TextUtils
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.PassWorkContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.PassWorkModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PassWorkPresenter:PassWorkContract.Presenter() {
    override fun setCode(phone: String) {
        if (TextUtils.isEmpty(phone)){
            getView()?.showToast("请输入手机号")
            getView()?.dismissLoadingDialog()
            return
        }else if (11!=phone.length){
            getView()?.showToast("请输入正确的手机号")
            getView()?.dismissLoadingDialog()
            return
        }

        getModel().setCode(phone).ui({
            if (it.status.equals("1"))
                getView()?.showToast("发送成功")
                getView()?.getCode()
        },{

        })

    }

    override fun setPW(token: String, phone_code: String, password: String) {
        if (TextUtils.isEmpty(phone_code)){
            getView()?.showToast("请输入验证码")
            getView()?.dismissLoadingDialog()
            return
        }else if (6!=phone_code.length){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }

        if (TextUtils.isEmpty(password)||password.length<6||password.length>16){
            getView()?.showToast("请输入6到16位密码")
            getView()?.dismissLoadingDialog()
            return
        }

        getModel().setPW(token,phone_code,password).ui({
            if (it.status.equals("1")){
                getView()?.setSucceful()
                getView()?.showToast(it.msg)
            }

        },{
            getView()?.dismissLoadingDialog()
                getView()?.showToast(it)
        })

    }

    override fun setPayPW(token: String, phone_code: String, password: String) {
        if (TextUtils.isEmpty(phone_code)){
            getView()?.showToast("请输入验证码")
            getView()?.dismissLoadingDialog()
            return
        }else if (6!=phone_code.length){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }
        if (TextUtils.isEmpty(password)||password.length!=6){
            getView()?.showToast("请输入6位密码")
            getView()?.dismissLoadingDialog()
            return
        }

        getModel().setPayPW(token,phone_code,password).ui({
            if (it.status.equals("1")){
                getView()?.setSucceful()
                getView()?.showToast(it.msg)
            }

        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)

        })
    }

    override fun setPhone(token: String, phone_code: String, phone: String) {
        if (TextUtils.isEmpty(phone_code)){
            getView()?.showToast("请输入验证码")
            getView()?.dismissLoadingDialog()
            return
        }else if (6!=phone_code.length){
            getView()?.showToast("请输入6位验证码")
            getView()?.dismissLoadingDialog()
            return
        }

        if (TextUtils.isEmpty(phone)){
            getView()?.showToast("请输入手机号")
            getView()?.dismissLoadingDialog()
            return
        }else if (11!=phone.length){
            getView()?.showToast("请输入正确的手机号")
            getView()?.dismissLoadingDialog()
            return
        }

        getModel().setPhone(token,phone_code,phone).ui({
            if (it.status.equals("1")){
                getView()?.setSucceful()
                getView()?.showToast(it.msg)
            }

        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): PassWorkContract.Model =PassWorkModel()
}