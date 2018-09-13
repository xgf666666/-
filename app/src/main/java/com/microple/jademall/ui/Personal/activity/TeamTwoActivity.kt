package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Team
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.TeamAdapter
import com.microple.jademall.ui.Personal.mvp.contract.MyTeamContract
import com.microple.jademall.ui.Personal.mvp.presenter.MyTeamPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_my_team.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:我的团队二级团队
 */
class TeamTwoActivity : BaseMvpActivity<MyTeamPresenter>(),MyTeamContract.View {
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
    override fun getActivityLayoutId(): Int =R.layout.activity_team_two

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="我的团队"
        getPresenter().team(Constants.getToken(),intent.getStringExtra("user_id"))
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun team(team: Team) {
        loading.visibility= View.GONE
        adapter.setNewData(team.user_list)
        tv_all.text=team.total_money
        tv_number.text=""+team.user_count
    }

    companion object {
        fun startTeamTwoActivity(context: Context,user_id:String){
            val intent = Intent(context,TeamTwoActivity::class.java)
            intent.putExtra("user_id",user_id)
            context.startActivity(intent)
        }
    }
    var adapter= TeamAdapter(arrayListOf())
}
