package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.NeedNoteContract
import com.microple.jademall.ui.Personal.mvp.presenter.NeedNotePresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_need_note.*
import kotlinx.android.synthetic.main.item_title.*

class NeedNoteActivity : BaseMvpActivity<NeedNotePresenter>(),NeedNoteContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): NeedNotePresenter = NeedNotePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_need_note

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="入驻协议"
        getPresenter().getNoteContent(Constants.getToken())
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_submint.setOnClickListener {
            ApplicationActivity.startApplicationActivity(this)
            finish()
        }
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun getNoteContent(value: String) {
        loading.visibility= View.GONE
        tv_content.text=value
    }

    companion object {
        fun startNeedNoteActivity(context: Context){
            val intent = Intent(context, NeedNoteActivity::class.java)
            context.startActivity(intent)
        }
    }

}
