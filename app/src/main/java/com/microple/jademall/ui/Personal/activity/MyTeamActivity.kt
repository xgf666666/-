package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.TeamAdapter
import com.microple.jademall.ui.Personal.mvp.presenter.MyTeamPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_my_team.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:我的团队
 */
class MyTeamActivity : BaseMvpActivity<MyTeamPresenter>() {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): MyTeamPresenter = MyTeamPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_my_team

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="我的团队"
        var adapter= TeamAdapter(arrayListOf())
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        var data = arrayListOf( "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            TeamTwoActivity.startTeamTwoActivity(this)

        }
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }

    companion object {
        fun startMyTeamActivity(context: Context){
            val intent = Intent(context,MyTeamActivity::class.java)
            context.startActivity(intent)
        }
    }

}
