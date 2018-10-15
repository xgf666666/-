package com.microple.jademall.common

import android.app.Activity
import android.support.multidex.MultiDexApplication
import cn.jpush.android.api.JPushInterface
import com.blankj.utilcode.util.Utils
import com.facebook.stetho.Stetho
import com.microple.jademall.BuildConfig
import com.tencent.imsdk.TIMLogLevel
import com.tencent.imsdk.TIMManager
import com.tencent.imsdk.TIMSdkConfig
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig
import com.xx.anypay.WxAppIDProvider
import com.xx.anypay.XxAnyPay
import com.xx.baseutilslibrary.network.provider.JApiConfigProvider
import com.xx.baseutilslibrary.network.retrofit.Retrofit2Manager

/**
 * author: Gubr
 * date: 2018/5/9
 * describe:
 */
class App : MultiDexApplication(){
var activitys=ArrayList<Activity>()

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        Utils.init(this)
        Stetho.initializeWithDefaults(this)
        UMInit()
        XxAnyPay.intance.init(this)
        XxAnyPay.intance.wxAppIDProvider = object : WxAppIDProvider {
            override val weChatAppID: String
                get() = "wx004a70c4275f88f3"
        }
        Retrofit2Manager.instance.apiConfigProvider = object : JApiConfigProvider {
            override fun getApiRelativePath(): String {
                return "/api/"
            }

            override fun getDebugHost(): String {
//                return "http://192.168.0.150"
                return BuildConfig.DEV_DOMAIN+"/api/"
            }

            override fun getReleaseHost(): String {
                return BuildConfig.RELEASE_DOMAIN

            }

            override fun isDebug(): Boolean {
                return BuildConfig.IS_DEV

            }

        }
        //全局监听前后台
        registerActivityLifecycleCallbacks(MyLifecycleHandler())
    }
    fun addActivity(activity: Activity){
       if (!activitys.contains(activity)){
        activitys.add(activity)
      }
   }
   fun cleanActivity(){
    if (activitys.size!=0)
        for (i in 0 ..activitys.size-1){
            activitys[i].finish()
        }
   }
    fun deleteActivity(activity: Activity){
        if (activitys.contains(activity))
            activitys.remove(activity)
    }

    private fun UMInit() {
        //极光推送
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
//        //初始化友盟
        UMConfigure.init(this, "5b4c573e8f4a9d233f000140", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "")
        PlatformConfig.setWeixin("wx004a70c4275f88f3", "0cc3cd436d04176d4342f1d1c2855cac")
        PlatformConfig.setSinaWeibo("4126164385", "9d210086099b4968457c638ad34d1f00", "http//:www.baidu.com")
//        PlatformConfig.setSinaWeibo("4285643628", "0dcfdb9213e48fb0bfd8f7479f208bf8", "http:www.baidu.com")
        PlatformConfig.setQQZone("1107787297", "a3xMHkjE3hdRRRsw")
//        var confit=TIMSdkConfig(1400140544)
//        confit.setAccoutType(39130)
//        TIMManager.getInstance().init(this,confit)

    }

    companion object {
        @JvmStatic
        private var sInstance: App? = null

        fun getInstance(): App? {
            return sInstance
        }
    }


}