package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.bean.IntergrationDetail
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.IntergrationDetailContract
import com.microple.jademall.ui.Personal.mvp.presenter.IntergrationDetailPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_intergration_detail.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguangfei
 * date: 2018/8/8.
 * describe:积分详情
 */
class IntergrationDetailActivity : BaseMvpActivity<IntergrationDetailPresenter>(),IntergrationDetailContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): IntergrationDetailPresenter = IntergrationDetailPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_intergration_detail

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="积分明细详情"
        var up_id=intent.getStringExtra("up_id")
        getPresenter().getDetail(Constants.getToken(),up_id)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
    }

    override fun getDetail(detail: IntergrationDetail) {
        loading.visibility= View.GONE
        tv_shop.text=detail.point_detail.supplier_name
        tv_jifen.text=detail.point_detail.points_change+"积分"
        tv_jiaoyi.text=detail.point_detail.desc
        tv_time.text=detail.point_detail.add_time
        tv_shengyu.text=""+detail.point_detail.points
        tv_beizhu.text=detail.point_detail.remark
    }

    companion object {
        fun startIntergrationDetailActivity(context: Context,up_id:String){
            val intent = Intent(context,IntergrationDetailActivity::class.java)
            intent.putExtra("up_id",up_id)
            context.startActivity(intent)
        }
    }

}
