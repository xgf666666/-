package com.microple.jademall.uitls

import android.content.Context
import com.flyco.dialog.listener.OnBtnClickL
import com.flyco.dialog.widget.NormalDialog
import com.microple.jademall.R
import com.microple.jademall.common.Constants
import com.xx.baseuilibrary.BaseActivity
import com.xx.baseuilibrary.BaseFragment
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.exception.ApiFaileException
import com.xx.baseutilslibrary.network.exception.TokenInvalidException
import retrofit2.HttpException
import java.math.BigDecimal
import java.net.ConnectException
import java.net.SocketTimeoutException
/**
 * author: HuaiXianZhong
 * date: 2018/7/10
 * describe:
 */

fun BaseMvpView.showToast(throwable:Throwable){
    var msg = ""

    if (throwable is HttpException) {
        val code = throwable.code()
        if (code == 500 || code == 404) {
            msg="服务器错误,请稍后重试"
        }
    } else if (throwable is ConnectException) {
        //断开网络
    } else if (throwable is SocketTimeoutException) {
        msg="连接服务器超时,请稍后重试"
    } else if (throwable is ApiFaileException) {
        msg=throwable.message!!//接口请求状态为0的情况
    } else if (throwable is TokenInvalidException) {
        msg="状态异常，请重新登录！"//需要重新登录获取
        if (this is BaseActivity){
            tokenError((this as Context),msg)
        }else if (this is BaseFragment){
            tokenError((this as BaseFragment).context!!,msg)
        }else{
            showToast(msg)
        }
        return
    } else {
        msg="未知错误" + throwable.message
    }
    showToast(msg)
}


fun tokenError(context : Context,msg:String){
    Constants.loginOut()
    var dialog = NormalDialog(context)
    dialog.style(NormalDialog.STYLE_TWO)
            .content(msg)
            .title("提示")
            .style(NormalDialog.STYLE_TWO)
            .contentTextSize(17f)
            .titleTextSize(17f)
            .contentTextColor(context.resources.getColor(R.color.black_666666))
            .titleTextColor(context.resources.getColor(R.color.black_333333))
            .btnNum(1)
            .btnText("确定")
            .btnTextColor(context.resources.getColor(R.color.color3078EF))
            .setCancelable(false)
    dialog.setCanceledOnTouchOutside(false)
    dialog.show()
    dialog.setOnBtnClickL(OnBtnClickL {
        dialog.dismiss()
//        context.startActivity(Intent(context, LoginActivity::class.java))
    })
}



/**
 * m 转换 km
 */
fun Int.changeKm() : String{
    if (this >= 1000){
        var d = this / 1000.00
        var toDouble = BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
        return toDouble.toString()+"km"
    }else{
        return this.toString() + "m"
    }
}

