package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
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
import java.math.BigDecimal
import java.text.NumberFormat

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:我的团队
 */
class MyTeamActivity : BaseMvpActivity<MyTeamPresenter>(),MyTeamContract.View {
    override fun team(team: Team) {
        loading.visibility= View.GONE
        adapter.setNewData(team.user_list)
        if (!team.total_money.isNullOrEmpty())
            if (!team.total_money.isNullOrEmpty()){
                var dd=NumberFormat.getNumberInstance()
                dd.minimumFractionDigits=2
                dd.maximumFractionDigits=2
                tv_all.text=""+dd.format(team.total_money.toDouble())
            }
        tv_number.text=""+team.user_count

    }

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
    var adapter= TeamAdapter(arrayListOf())
    override fun initData() {
        tv_title.text="我的团队"
        getPresenter().team(Constants.getToken(),"")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            TeamTwoActivity.startTeamTwoActivity(this,""+(adapter as TeamAdapter).data[position].user_id)
        }
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
    }

    companion object {
        fun startMyTeamActivity(context: Context){
            val intent = Intent(context,MyTeamActivity::class.java)
            context.startActivity(intent)
        }
    }

}
