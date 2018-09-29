package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.AboutMe
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AboutMelModel: AboutMeContract.Model {
    override fun aboutMe(): Observable<BaseResponseEntity<AboutMe>> =AppApi.Api().aboutMe()

}