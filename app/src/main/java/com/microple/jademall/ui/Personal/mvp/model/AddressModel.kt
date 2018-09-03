package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Address
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AddressModel: AddressContract.Model {
    override fun delAddress(token: String, address_id: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().DelAddress(token,address_id)

    override fun settingAddress(token: String, address_id: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().SettingAddress(token,address_id)

    override fun getAddress(token: String): Observable<BaseResponseEntity<Address>> =AppApi.Api().getAddress(token)
}