package com.microple.jademall.ui.live.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.microple.jademall.R
import com.tencent.rtmp.ITXLivePlayListener
import com.tencent.rtmp.TXLiveBase
import com.tencent.rtmp.TXLiveConstants
import com.tencent.rtmp.TXLivePlayer
import kotlinx.android.synthetic.main.activity_live_player.*

class LivePlayerActivity : AppCompatActivity() {
    var mLivePlayer:TXLivePlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_player)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        play()
        hideStatusBar()
    }
    fun play(){
        val sdkver = TXLiveBase.getSDKVersionStr()
        Log.d("liteavsdk", "liteav sdk version is : $sdkver")
        mLivePlayer=TXLivePlayer(this)
        mLivePlayer?.setPlayerView(video_view)
        val flvUrl = "rtmp://30381.liveplay.myqcloud.com/live/30381_83c9d76844"
        mLivePlayer?.startPlay(flvUrl, TXLivePlayer.PLAY_TYPE_LIVE_RTMP)
        mLivePlayer?.setRenderMode(TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN)
        mLivePlayer?.setRenderRotation(TXLiveConstants.RENDER_ROTATION_PORTRAIT)
        mLivePlayer?.setPlayListener(object : ITXLivePlayListener {
            override fun onPlayEvent(event: Int, param: Bundle?) {
                if (event == TXLiveConstants.PLAY_ERR_NET_DISCONNECT) {
                    Log.i("TXLiveConstants","网络断开")

                }else if (event == TXLiveConstants.PLAY_EVT_GET_MESSAGE){
                    Log.i("TXLiveConstants","heheheh")
                }else{
                    Log.i("TXLiveConstants","hahahha")

                }
            }

            override fun onNetStatus(p0: Bundle?) {
            }

        })
        iv_close.setOnClickListener{
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mLivePlayer?.stopPlay(true)
        video_view.onDestroy()
    }
    companion object {
        fun startLivePlayerActivity(context: Context){
            val intent = Intent(context, LivePlayerActivity::class.java)
            context.startActivity(intent)
        }
    }
    //只透明状态栏
    private fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

}
