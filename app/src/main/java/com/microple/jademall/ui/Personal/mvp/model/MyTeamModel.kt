package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Team
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MyTeamContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyTeamModel: MyTeamContract.Model {
    override fun team(token: String, user_id: String): Observable<BaseResponseEntity<Team>> =AppApi.Api().team(token, user_id)
}