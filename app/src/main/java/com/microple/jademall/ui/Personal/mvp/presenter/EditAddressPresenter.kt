package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.EditAddressContract
import com.microple.jademall.ui.Personal.mvp.model.EditAddressModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.bangbang.common.isPhone
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class EditAddressPresenter:EditAddressContract.Presenter() {
    override fun addEdit(token: String, receiver: String, phone: String, address: String) {
        if (receiver.isNullOrEmpty()){
            getView()?.showToast("请输入收件人")
            getView()?.dismissLoadingDialog()
            return
        } else if (!phone.isPhone()){
            getView()?.showToast("请输入正确联系方式")
            getView()?.dismissLoadingDialog()
            return
        }else if (address.isNullOrEmpty()){
            getView()?.showToast("请输入地址")
            getView()?.dismissLoadingDialog()
            return
        }

        getModel().addEdit(token,receiver,phone,address).ui({
            getView()?.setEditSuccssful(it.msg!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun setEdit(token: String, id: String, receiver: String, phone: String, address: String) {
        if (receiver.isNullOrEmpty()){
            getView()?.showToast("请输入收件人")
            getView()?.dismissLoadingDialog()
            return
        } else if (!phone.isPhone()){
            getView()?.showToast("请输入正确联系方式")
            getView()?.dismissLoadingDialog()
            return
        }else if (address.isNullOrEmpty()){
            getView()?.showToast("请输入地址")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().setEdit(token,id,receiver,phone,address).ui({
            getView()?.setEditSuccssful(it.msg!!)
        },{
            getView()?.showToast(it)
        })
    }

    override fun createModel(): EditAddressContract.Model =EditAddressModel()
}