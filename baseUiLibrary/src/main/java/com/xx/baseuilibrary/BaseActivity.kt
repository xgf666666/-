package com.xx.baseuilibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.xx.baseutilslibrary.status_bar.StatusBarUtils
import kotlinx.android.synthetic.main.layout_tool_bar.*


/**
 * BaseActivity
 * (。・∀・)ノ
 * Describe：封装AppCompatActivity一级基类
 * Created by 雷小星🍀 on 2017/10/30 15:21.
 */

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        StatusBarUtils.apply(this, true)
        var layoutId = getActivityLayoutId()
        if (layoutId > 0) {
            setContentView(getActivityLayoutId())
            setSupportActionBar(toolBar)
        }
        init()
    }

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    protected abstract fun getActivityLayoutId(): Int

    /**
     * 初始化
     */
    protected abstract fun init()


}
