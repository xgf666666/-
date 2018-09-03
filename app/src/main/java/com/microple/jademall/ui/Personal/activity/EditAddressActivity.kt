package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.microple.jademall.R
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.EditAddressContract
import com.microple.jademall.ui.Personal.mvp.presenter.EditAddressPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_edit_address.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:新增编辑收货地址
 */
class EditAddressActivity : BaseMvpActivity<EditAddressPresenter>(),EditAddressContract.View {

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): EditAddressPresenter = EditAddressPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_edit_address

    /**
     * 初始化数据状态
     */
    override fun initData() {
        Log.i("ua_id",intent.getStringExtra("ua_id"))
        if (intent.getStringExtra("ua_id").isNullOrEmpty()){
            tv_title.text="增加收货地址"
        }else{
            tv_title.text="编辑收货地址"
        }
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        tv_edit.setOnClickListener{
            showLoadingDialog()
            if (intent.getStringExtra("ua_id").isNullOrEmpty()){
                getPresenter().addEdit(Constants.getToken(),et_name.text.toString(),et_phone.text.toString(),et_address.text.toString())

            }else{
                getPresenter().setEdit(Constants.getToken(),intent.getStringExtra("ua_id"),et_name.text.toString(),et_phone.text.toString(),et_address.text.toString())
            }
        }
    }

    override fun setEditSuccssful(msg: String) {
        showToast(msg)
        dismissLoadingDialog()
        finish()
    }

    companion object {
        fun startEditAddressActivity(context: Context,ua_id:String){
            val intent = Intent(context, EditAddressActivity::class.java)
            intent.putExtra("ua_id",ua_id)
            context.startActivity(intent)
        }
    }

}
