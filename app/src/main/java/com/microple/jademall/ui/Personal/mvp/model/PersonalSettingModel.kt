package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.HandImage
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.PersonalSettingContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PersonalSettingModel: PersonalSettingContract.Model {
    override fun setHandImageView(token: String, head_img: String): Observable<BaseResponseEntity<HandImage>> = AppApi.Api().setHandImage(token,head_img)
}