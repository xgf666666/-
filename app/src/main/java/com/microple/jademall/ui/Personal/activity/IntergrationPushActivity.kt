package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.AccountIinfo
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.IntergrationPushAdapter
import com.microple.jademall.ui.Personal.mvp.contract.IntergrationPushContract
import com.microple.jademall.ui.Personal.mvp.presenter.IntergrationPushPresenter
import com.microple.jademall.uitls.loadImag
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_intergration_push.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:积分转账
 */
class IntergrationPushActivity : BaseMvpActivity<IntergrationPushPresenter>(),IntergrationPushContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): IntergrationPushPresenter = IntergrationPushPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_intergration_push

    /**
     * 初始化数据状态
     */
    var adapter=IntergrationPushAdapter(arrayListOf())
    override fun initData() {
        tv_title.setText("积分转账")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        recyclerView.isNestedScrollingEnabled = false
    }

    override fun onResume() {
        super.onResume()
        getPresenter().getAccout(Constants.getToken())
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        tv_sure.setOnClickListener{
            if (tv_keyong.text.toString().isNullOrEmpty()&&tv_dongjie.text.toString().isNullOrEmpty()){
                showToast("请输入转账积分")
            }else if (!tv_keyong.text.isNullOrEmpty()&&pay_points.toDouble()<tv_keyong.text.toString().toDouble()){
                            showToast("请输入积分小于可用的")
            } else if (!tv_dongjie.text.isNullOrEmpty()&&pay_dongjie.toDouble()<tv_dongjie.text.toString().toDouble()){
                    showToast("请输入积分小于可用的")
            }else{
                showLoadingDialog()
                getPresenter().push(Constants.getToken(),et_zhanhao.text.toString(),tv_keyong.text.toString(),tv_dongjie.text.toString())
            }
        }

    }
    var pay_points=""
    var pay_dongjie=""
    override fun getAccout(accoutInfo: AccountIinfo) {
        iv_head.loadImag(accoutInfo.user_info.head_img)
        tv_name.text=accoutInfo.user_info.user_name
        tv_keyong.hint="可用积分"+accoutInfo.user_info.pay_points
        pay_points=accoutInfo.user_info.pay_points
        pay_dongjie=accoutInfo.user_info.frozen_points
        tv_dongjie.hint="冻结积分"+accoutInfo.user_info.frozen_points
        adapter.setNewData(accoutInfo.record)
        loading.visibility= View.GONE
    }

    override fun push() {
        showToast("转账成功")
        dismissLoadingDialog()
        finish()
    }

    companion object {
        fun startIntergrationPushActivity(context: Context){
            val intent = Intent(context,IntergrationPushActivity::class.java)
            context.startActivity(intent)
        }
    }

}
