package com.microple.jademall.ui.home.fragment

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.microple.jademall.BuildConfig
import com.microple.jademall.R
import com.microple.jademall.uitls.loadImag
import com.xx.baseuilibrary.BaseFragment
import kotlinx.android.synthetic.main.fragment_common.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/27
 * describe:
 */
class BannerFragment :BaseFragment() {
    /**
     * 获取Fragment的布局资源文件id
     */
    override fun getFragmentLayoutId(): Int = R.layout.fragment_common


    /**
     * 初始化
     */
    override fun init(view: View?) {
        val bundle = arguments
        var banner_id=bundle!!.get("banner_id")
        var img=bundle!!.getString("img")!!
        iv_banner.loadImag(img)
    }
}