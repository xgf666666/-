package com.microple.jademall.ui.home.mvp.model

import android.media.Image
import com.microple.jademall.bean.ImageDetail
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.home.mvp.contract.ImageDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ImageDetailModel: ImageDetailContract.Model {
    override fun getImageDetail(goods_id: String): Observable<BaseResponseEntity<ImageDetail>> =AppApi.Api().getImageDetail(goods_id)
}