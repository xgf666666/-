package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Pick
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.PickGoodsContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PickGoodsModel: PickGoodsContract.Model {
    override fun pick(token: String, ct_id: String): Observable<BaseResponseEntity<Pick>> =AppApi.Api().pick(token, ct_id)
}