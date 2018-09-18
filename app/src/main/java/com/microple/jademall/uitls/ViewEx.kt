package com.microple.jademall.uitls

import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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
    }else{
        urltemp=url
    }
    Glide.with(this.context).load(urltemp).apply(RequestOptions()
            .placeholder(R.drawable.ic_img_default)
            .error(R.drawable.ic_img_default))
            .into(this)
}
fun ImageView.loadHeadImag( url: String) {
    var urltemp=url
    if (url.length>1&&url[0].equals('/')) {
        urltemp=Retrofit2Manager.instance.apiConfigProvider?.releaseHost+url
    }else{
        urltemp=url
    }
    Glide.with(this.context).load(urltemp).apply(RequestOptions()
            .placeholder(R.drawable.datouxiang_)
            .error(R.drawable.datouxiang_))
            .into(this)
}


fun TextView.setHtmlText(content: String) {
    this.text = Html.fromHtml(content)
}

fun TextView.getTString()=this.text.toString().trim()



//fun View.setOnPerCheckLoginClickListner(back:(v:View)->Unit){
//    this.setOnClickListener {
//        if (com.weibiaogan.bangbang.common.Constants.isLogin()) {
//            back.invoke(it)
//        }else{
//            val intent = android.content.Intent(it.context, com.weibiaogan.bangbang.ui.login.LoginActivity::class.java)
////            val intent = android.content.Intent(it.context, com.weibiaogan.litong.ui.project.PayCenterActivity::class.java)
//            it.context.startActivity(intent)
//        }
//    }
//}