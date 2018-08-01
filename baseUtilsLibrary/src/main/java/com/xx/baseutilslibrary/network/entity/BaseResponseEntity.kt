package com.xx.baseutilslibrary.network.entity

/**
 * ResponseEntity
 * 类描述: 公共响应体
 * 上次更新内容:
 * 上次更新时间:
 * 上次更新作者:
 * 作者: LeiXiaoXing on 2017/1/9 20:08
 */

class BaseResponseEntity<T> {

    var status: Int = 0
    var msg: String? = null
    var data: T? = null


}
