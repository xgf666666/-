package com.microple.jademall.ui.Personal

import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.bean.*
import com.microple.jademall.ui.Personal.adapter.PersonlCommonAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlHelpAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlOrderAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlSettingAdapter
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.activity.*
import com.microple.jademall.ui.Personal.mvp.contract.PersonalContract
import com.microple.jademall.ui.Personal.mvp.presenter.PersonalPresenter
import com.microple.jademall.uitls.loadHeadImag
import com.microple.jademall.uitls.loadImag
import com.xx.baseuilibrary.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_personl.*
import kotlinx.android.synthetic.main.item_login.*

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:
 */
class PersonlFragment : BaseMvpFragment<PersonalContract.Model,PersonalContract.View,PersonalPresenter>(),PersonalContract.View {
    override fun getInfo(personalInfo: PersonInfo) {
        loading.visibility=View.GONE
        iv_head.loadHeadImag(personalInfo.info.head_img)
        if (personalInfo.info.user_name.isNullOrEmpty()){
            tv_name.text="请设置昵称"

        }else{
            tv_name.text=personalInfo.info.user_name
        }
        tv_phone.text=personalInfo.info.phone
        Constants.putPersonal(personalInfo.info)
        Constants.putHeadImg(personalInfo.info.head_img)
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): PersonalPresenter = PersonalPresenter()

    private lateinit var mOrderAdapter: PersonlOrderAdapter//我的订单
    private lateinit var mSettingAdapter: PersonlSettingAdapter//设置
    private lateinit var mCommonAdapter: PersonlCommonAdapter//通用功能
    private lateinit var mHelpAdapter: PersonlHelpAdapter//帮助
    override fun getFragmentLayoutId(): Int = R.layout.fragment_personl

    override fun init(view: View?) {
        iv_setting.setOnClickListener{
            Constants.loginOut()

            LoginActivity.startLoginActivity(context!!)
        }
        iv_head.setOnClickListener {
            PersonalSettingActivity.startPersonalSettingActivity(context!!)
        }
        scrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if (scrollY>=90){
                tv_title.visibility=View.VISIBLE
                tv_title.text="个人中心"
            }else{
                tv_title.visibility=View.GONE
            }
        }
        //我的订单
        rv_myOrder.layoutManager = LinearLayoutManager(context)
        mOrderAdapter = PersonlOrderAdapter(R.layout.item_personal, PersonOrderBean.createList())
        rv_myOrder.adapter = mOrderAdapter
        rv_myOrder.isNestedScrollingEnabled = false
        //设置
        rv_setting.layoutManager = LinearLayoutManager(context)
        mSettingAdapter = PersonlSettingAdapter(R.layout.item_personal, PersonSettingBean.createList())
        rv_setting.adapter = mSettingAdapter
        rv_setting.isNestedScrollingEnabled = false

        //通用功能
        rv_common.layoutManager = LinearLayoutManager(context)
        mCommonAdapter = PersonlCommonAdapter(R.layout.item_personal, PersonCommonBean.createList())
        rv_common.adapter = mCommonAdapter
        rv_common.isNestedScrollingEnabled = false

        //帮助
        rv_help.layoutManager = LinearLayoutManager(context)
        mHelpAdapter = PersonlHelpAdapter(R.layout.item_personal, PersonHelpBean.createList())
        rv_help.adapter = mHelpAdapter
        rv_help.isNestedScrollingEnabled = false
        iv_message.setOnClickListener{
            MessageActivity.startMessageActivity(context!!)
        }
        mOrderAdapter.setOnItemClickListener { adapter, view, position ->
           when(position){//我的订单
               0->{
                   AllOrderActivity.startAllOrderActivity(context!!,0)
               }
               1->{
                   AllOrderActivity.startAllOrderActivity(context!!,1)

               }
               2->{
                   AllOrderActivity.startAllOrderActivity(context!!,3)
               }
               3->{
                   AllOrderActivity.startAllOrderActivity(context!!,4)
               }
               4->{
                   AllOrderActivity.startAllOrderActivity(context!!,5)

               }
               5->{
                   CustomerOrderActivity.startCustomerOrderActivity(context!!)
               }
           }
        }
        mSettingAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0->{
                    PersonalSettingActivity.startPersonalSettingActivity(context!!)
                }
                1->{
                    AddressActivity.startAddressActivity(context!!)
                }
                2->{
                    SafeSettingActivity.startSafeSettingActivity(context!!)
                }
            }
        }
        mCommonAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0->{
                    MyCollectionActivity.startMyCollectionActivity(context!!)
                }
                1->{
                    MyAppointmentActivity.startMyAppointmentActivity(context!!)
                }
                2->{
                    MyAssetActivity.startMyAssetActivity(context!!)
                }
                3->{
                    ShareActivity.startShareActivityMerchantEntryActivity(context!!)
                }
                4->{
                    MyTeamActivity.startMyTeamActivity(context!!)
                }
                5->{
                    MerchantEntryActivity.startMerchantEntryActivity(context!!)
                }
            }
        }
        mHelpAdapter.setOnItemClickListener { adapter, view, position ->
            when(position){
                0->{
                    AskQuestionTypeActivity.startAskQuestionTypeActivity(context!!)
                }
                1->{
                    CustomerServiceAcitivity.startCustomerServiceAcitivity(context!!)
                }
                2->{
                    FeedBackActivity.startFeedBackActivity(context!!)
                }
                3->{
                    AboutMeActivity.startAboutMeActivity(context!!)
                }
            }
        }
        tv_login.setOnClickListener{
            LoginActivity.startLoginActivity(context!!)
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden){
            if (Constants.isLogin()){
                Log.i("Constantssss",Constants.getToken())
                getPresenter().getInfo(Constants.getToken())
                view_login.visibility=View.GONE
            }else{
                view_login.visibility=View.VISIBLE
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (!isHidden){
            if (Constants.isLogin()){
                Log.i("Constantssss",Constants.getToken())
                getPresenter().getInfo(Constants.getToken())
                view_login.visibility=View.GONE
            }else{
                view_login.visibility=View.VISIBLE
            }

        }
    }
}