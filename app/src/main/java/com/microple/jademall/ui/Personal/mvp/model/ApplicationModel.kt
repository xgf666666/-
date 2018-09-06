package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Image
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.ApplicationContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ApplicationModel: ApplicationContract.Model {
    override fun apply(token: String, supplier_name: String, email: String, phone: String, inviter: String, license: String, attach: String): Observable<BaseResponseEntity<Any>> =
            AppApi.Api().apply(token,supplier_name,email,phone,inviter,license,attach)

    override fun getImage(upload_img: String): Observable<BaseResponseEntity<Image>> =AppApi.Api().getImage(upload_img)
}