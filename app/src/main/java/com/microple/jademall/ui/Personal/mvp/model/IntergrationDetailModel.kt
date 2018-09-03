package com.microple.jademall.ui.Personal.mvp.model


import com.microple.jademall.bean.IntergrationDetail
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.IntergrationDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class IntergrationDetailModel: IntergrationDetailContract.Model {
    override fun getDetail(token: String, up_id: String): Observable<BaseResponseEntity<IntergrationDetail>> =AppApi.Api().getIntergrationDetail(token,up_id)
}