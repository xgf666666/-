package com.microple.jademall.uitls

import android.text.Html
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.microple.jademall.R
import com.xx.baseutilslibrary.network.retrofit.Retrofit2Manager

/**
 * author: Gubr
 * date: 2018/5/7
 * describe:
 */
  fun ImageView.loadImag( url: String) {
    var urltemp=url
    if (url.length>1&&url[0].equals('/')) {
        urltemp=Retrofit2Manager.instance.apiConfigProvider?.releaseHost+url
        Log.i("urltemp",Retrofit2Manager.instance.apiConfigProvider?.releaseHost+url)
    }else{
        urltemp=url
    }
    Glide.with(this.context).load(urltemp)
            .placeholder(R.drawable.ic_img_default)
            .dontAnimate()
            .error(R.drawable.ic_img_default)
            .into(this)
}
fun ImageView.loadHeadImag( url: String) {
    var urltemp=url
    if (url.length>1&&url[0].equals('/')) {
        urltemp=Retrofit2Manager.instance.apiConfigProvider?.releaseHost+url
    }else{
        urltemp=url
    }
    Glide.with(this.context).load(urltemp)
//            .placeholder(R.drawable.datouxiang_)
            .dontAnimate()
            .error(R.drawable.datouxiang_)
            .into(this)
}


fun TextView.setHtmlText(content: String) {
    this.text = Html.fromHtml(content)
}

fun TextView.getTString()=this.text.toString().trim()
