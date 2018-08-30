package com.weibiaogan.bangbang.common

import android.content.Context
import com.blankj.utilcode.util.EncryptUtils

fun String.md5Salt():String =
        EncryptUtils.encryptMD5ToString(EncryptUtils.encryptMD5ToString(this + "mcjp")
                .toLowerCase()).toLowerCase()
fun Int.pxtodp(context: Context):Int{
    var scale = context.getResources().getDisplayMetrics().density
    return (this * scale + 0.5f).toInt()
}