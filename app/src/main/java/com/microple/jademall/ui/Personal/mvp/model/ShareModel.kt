package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Share
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.ShareContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ShareModel: ShareContract.Model {
    override fun getShare(token: String): Observable<BaseResponseEntity<Share>> =AppApi.Api().myShare(token)
}