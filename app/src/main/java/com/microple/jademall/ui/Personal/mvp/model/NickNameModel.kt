package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.LiveSign
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.NickNameContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class NickNameModel: NickNameContract.Model {
    override fun setNickName(token: String, nickname: String): Observable<BaseResponseEntity<LiveSign>> =AppApi.Api().setNickName(token,nickname)
}