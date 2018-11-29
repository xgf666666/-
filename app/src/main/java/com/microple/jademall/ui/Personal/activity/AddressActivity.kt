package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Address
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.adapter.AddressAdapter
import com.microple.jademall.ui.Personal.mvp.contract.AddressContract
import com.microple.jademall.ui.Personal.mvp.presenter.AddressPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.item_title.*
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.item_address.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:管理收货地址
 */
class AddressActivity : BaseMvpActivity<AddressPresenter>(), AddressContract.View {
    var id = ""
    override fun setAddress(msg: String) {
        dismissLoadingDialog()
        showToast(msg)
//        var flag=intent.getIntExtra("flag",0)
//        if (flag==1){
//            var intent=Intent()
//            intent.putExtra("id",id)
//            setResult(4,intent)
//            finish()
//        }

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): AddressPresenter = AddressPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int = R.layout.activity_address


    /**
     * 初始化数据状态
     */
    var adapter = AddressAdapter(arrayListOf())

    override fun initData() {
        tv_title.text = "管理收货地址"
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            var flag = intent.getIntExtra("flag", 0)
            if (flag == 1) {
                var intent = Intent()
                intent.putExtra("name", (adapter as AddressAdapter).data[position].consigner)
                intent.putExtra("phone", (adapter as AddressAdapter).data[position].phone)
                intent.putExtra("address", (adapter as AddressAdapter).data[position].address)
                intent.putExtra("id", "" + (adapter as AddressAdapter).data[position].ua_id)
                setResult(3, intent)
                finish()
            }
        }
        adapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.tv_bianji -> {
                    EditAddressActivity.startEditAddressActivity(this, "" + (adapter as AddressAdapter).data[position].ua_id, adapter.data[position].consigner, adapter.data[position].phone, adapter.data[position].address)
                }
                R.id.tv_del -> {
                    showLoadingDialog()
                    getPresenter().delAddress(Constants.getToken(), "" + (adapter as AddressAdapter).data[position].ua_id)
                    id = "" + (adapter as AddressAdapter).data[position].ua_id
                    adapter.remove(position)
                }
                R.id.tv_setting -> {
                    showLoadingDialog()
                    if (tv_setting.isChecked) {
                        tv_setting.setTextColor(resources.getColor(R.color.green_06A366))
                    } else {
                        tv_setting.setTextColor(resources.getColor(R.color.black_000000))
                    }
                    (adapter as AddressAdapter).setCheck(position)
                    getPresenter().settingAddress(Constants.getToken(), "" + (adapter as AddressAdapter).data[position].ua_id)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        showLoadingDialog()
        getPresenter().getAddress(Constants.getToken())
    }


    /**
     * 初始化事件
     */
    override fun initEvent() {
        tv_addAddress.setOnClickListener {
            EditAddressActivity.startEditAddressActivity(this, "", "", "", "")
        }
        iv_back.setOnClickListener {
            finish()
        }
    }

    override fun getAddress(address: Address) {
        dismissLoadingDialog()
        if (address.address.size == 0) {
            tv_tishi.visibility = View.VISIBLE
        } else {
            tv_tishi.visibility = View.GONE
        }
        adapter.setNewData(address.address)

    }

    companion object {
        fun startAddressActivity(context: Context) {
            val intent = Intent(context, AddressActivity::class.java)
            context.startActivity(intent)
        }
    }

}
