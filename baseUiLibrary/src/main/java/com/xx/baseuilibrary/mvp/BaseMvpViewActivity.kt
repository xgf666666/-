package com.xx.baseuilibrary.mvp

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import com.blankj.utilcode.util.ToastUtils
import com.xx.baseuilibrary.BaseActivity
import com.xx.baseuilibrary.R
import kotlinx.android.synthetic.main.layout_tool_bar.*

/**
 * BaseMvpViewActivity
 * (。・∀・)ノ
 * Describe：此Activity用于BaseView中的操作实现
 * Created by 雷小星🍀 on 2017/10/30 16:24.
 */

abstract class BaseMvpViewActivity : BaseActivity() {


    /**
     * 沉浸式状态栏
     */
    fun setImmerseToolBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val localLayoutParams = window.attributes
            localLayoutParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or localLayoutParams.flags
        }
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    override fun setTitle(title: CharSequence) {
        super.setTitle(null)
        tv_title?.text = title
        setBackVisibility(true)
    }

    /**
     * 设置返回按钮是否可见
     *
     * @param visibility
     */
    fun setBackVisibility(visibility: Boolean) {
        if (visibility) {
            toolBar?.setNavigationIcon(R.mipmap.global_btn_return)
            toolBar?.setNavigationOnClickListener(View.OnClickListener { finish() })
        } else {
            toolBar?.setNavigationIcon(null)
        }
    }

    /**
     * 设置白色样式标题
     */
    fun setWhiteStyleTitle() {
        toolBar?.setNavigationIcon(R.mipmap.global_btn_return)
        tv_title?.setTextColor(ContextCompat.getColor(this, android.R.color.black))
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
        ToastUtils.setBgColor(ContextCompat.getColor(this, android.R.color.black))
        ToastUtils.setMsgColor(ContextCompat.getColor(this, android.R.color.white))
        ToastUtils.setMsgTextSize(14)
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
                    .Builder(this)
                    .setView(R.layout.dialog_progress)
                    .create()
            alertDialog!!.setCanceledOnTouchOutside(false)
            if (alertDialog!!.window != null) {
                alertDialog!!.window!!.setBackgroundDrawable(ColorDrawable())
            }
        }
        runOnUiThread {
            alertDialog!!.show()
        }
    }

    /**
     * 隐藏加载进度框
     */
    fun dismissLoadingDialog() {
        if (alertDialog != null) {
            runOnUiThread {
                alertDialog!!.dismiss()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        dismissLoadingDialog()
    }
}
