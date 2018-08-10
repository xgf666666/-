package com.microple.jademall.ui.Personal

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.PersonlCommonAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlHelpAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlOrderAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlSettingAdapter
import com.microple.jademall.ui.Personal.bean.PersonCommonBean
import com.microple.jademall.ui.Personal.bean.PersonHelpBean
import com.microple.jademall.ui.Personal.bean.PersonOrderBean
import com.microple.jademall.ui.Personal.bean.PersonSettingBean
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_personl.view.*

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:
 */
class PersonlFragment : BaseMvpViewFragment(){

    private lateinit var mOrderAdapter : PersonlOrderAdapter
    private lateinit var mSettingAdapter : PersonlSettingAdapter
    private lateinit var mCommonAdapter : PersonlCommonAdapter
    private lateinit var mHelpAdapter : PersonlHelpAdapter
    private lateinit var mRootView : View
    override fun getFragmentLayoutId(): Int = R.layout.fragment_personl

    override fun init(view: View?) {
        mRootView = view!!
        //我的订单
        mRootView.rv_myOrder.layoutManager = LinearLayoutManager(context)
        mOrderAdapter = PersonlOrderAdapter(R.layout.item_personal_myorder, PersonOrderBean.createList())
        mRootView.rv_myOrder.adapter = mOrderAdapter

        //设置
        mRootView.rv_setting.layoutManager = LinearLayoutManager(context)
        mSettingAdapter = PersonlSettingAdapter(R.layout.item_personal_myorder, PersonSettingBean.createList())
        mRootView.rv_setting.adapter = mSettingAdapter

        //通用功能
        mRootView.rv_common.layoutManager = LinearLayoutManager(context)
        mCommonAdapter = PersonlCommonAdapter(R.layout.item_personal_myorder, PersonCommonBean.createList())
        mRootView.rv_common.adapter = mCommonAdapter

        //帮助
        mRootView.rv_help.layoutManager = LinearLayoutManager(context)
        mHelpAdapter = PersonlHelpAdapter(R.layout.item_personal_myorder, PersonHelpBean.createList())
        mRootView.rv_help.adapter = mHelpAdapter

    }
}