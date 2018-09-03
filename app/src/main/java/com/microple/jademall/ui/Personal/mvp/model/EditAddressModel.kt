package com.microple.jademall.ui.Personal.mvp.model


import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.EditAddressContract


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class EditAddressModel: EditAddressContract.Model {
    override fun addEdit(token: String, receiver: String, phone: String, address: String) = AppApi.Api().addAddress(token,receiver,phone,address)

    override fun setEdit(token: String, id: String, receiver: String, phone: String, address: String) = AppApi.Api().editAddress(token,id,receiver,phone,address)
}