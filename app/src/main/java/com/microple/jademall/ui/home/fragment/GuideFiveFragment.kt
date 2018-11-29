package com.microple.jademall.ui.home.fragment

import android.view.View
import android.view.animation.AnimationUtils
import com.microple.jademall.MainActivity
import com.microple.jademall.R
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_guide_five.*

/**
 * author: xiaoguagnfei
 * date: 2018/9/28
 * describe:
 */
class GuideFiveFragment : BaseMvpViewFragment() {
    /**
     * 获取Fragment的布局资源文件id
     */
    override fun getFragmentLayoutId(): Int = R.layout.fragment_guide_five

    /**
     * 初始化
     */
    override fun init(view: View?) {
        rl_go.setOnClickListener {
            MainActivity.startMainActivity(context!!)
            activity!!.finish()
        }

    }

    public fun setAnim() {
        var anim_img = AnimationUtils.loadAnimation(context, R.anim.guide_img)
        anim_img.fillAfter = true
        var anim_txt = AnimationUtils.loadAnimation(context, R.anim.guide_tex)
        anim_txt.fillAfter = true
        iv_img.startAnimation(anim_img)
        tv_title.startAnimation(anim_txt)
    }

}