package com.xx.baseuilibrary.mvp

import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.xx.baseuilibrary.BaseFragment
import com.xx.baseuilibrary.R
import kotlinx.android.synthetic.main.fragment_tool_bar.*

/**
 * BaseMvpViewFragment
 * (。・∀・)ノ
 * Describe：
 * Created by 雷小星🍀 on 2017/11/2 18:22.
 */
abstract class BaseMvpViewFragment : BaseFragment() {

    /**
     * 设置标题
     *
     * @param title 标题
     */
    fun setTitle(title: CharSequence) {
        toolBar?.title = null
        tv_title?.text = title
        setBackVisibility(false)
    }

    fun setHeadImage(head: String){
        Glide.with(context!!).load(head).into(iv_head)

    }
    /**
     * 设置返回按钮是否可见
     *
     * @param visibility
     */
    fun setBackVisibility(visibility: Boolean) {
        if (visibility) {
            toolBar?.setNavigationIcon(R.mipmap.global_btn_return)
            toolBar?.setNavigationOnClickListener(View.OnClickListener { activity?.finish() })
        } else {
            toolBar?.setNavigationIcon(null)
        }
    }

    /**
     * 设置白色样式标题
     */
    fun setWhiteStyleTitle() {
        toolBar?.setNavigationIcon(R.mipmap.global_btn_return)
        tv_title?.setTextColor(ContextCompat.getColor(context!!, android.R.color.black))
    }



    /**
     * 显示Toast信息
     *
     * @param msg 消息信息
     */

    fun showToast(msg: String?) {
        if (TextUtils.isEmpty(msg)) {
            return
        }
        ToastUtils.setBgColor(ContextCompat.getColor(context ?: return, android.R.color.black))
        ToastUtils.setMsgColor(ContextCompat.getColor(context ?: return, android.R.color.white))
        ToastUtils.setGravity(Gravity.CENTER, 0, 0)
        ToastUtils.showShort(msg)
    }

    private var alertDialog: AlertDialog? = null
    /**
     * 显示加载进度框
     */
    fun showLoadingDialog() {
        if (alertDialog == null) {
            alertDialog = AlertDialog
                    .Builder(context ?: return)
                    .setView(R.layout.dialog_progress)
                    .create()
            alertDialog!!.setCanceledOnTouchOutside(false)
            if (alertDialog!!.window != null) {
                alertDialog!!.window!!.setBackgroundDrawable(ColorDrawable())
            }
        }
        activity!!.runOnUiThread {
            alertDialog!!.show()
        }
    }

    /**
     * 隐藏加载进度框
     */
    fun dismissLoadingDialog() {
        if (alertDialog != null) {
            activity!!.runOnUiThread {
                alertDialog!!.dismiss()
            }
        }
    }

}