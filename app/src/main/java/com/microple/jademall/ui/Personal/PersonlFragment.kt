package com.microple.jademall.ui.Personal

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.PersonlCommonAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlHelpAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlOrderAdapter
import com.microple.jademall.ui.Personal.adapter.PersonlSettingAdapter
import com.microple.jademall.bean.PersonCommonBean
import com.microple.jademall.bean.PersonHelpBean
import com.microple.jademall.bean.PersonOrderBean
import com.microple.jademall.bean.PersonSettingBean
import com.microple.jademall.ui.Personal.activity.*
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_personl.*

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:
 */
class PersonlFragment : BaseMvpViewFragment() {
    private lateinit var mOrderAdapter: PersonlOrderAdapter//我的订单
    private lateinit var mSettingAdapter: PersonlSettingAdapter//设置
    private lateinit var mCommonAdapter: PersonlCommonAdapter//通用功能
    private lateinit var mHelpAdapter: PersonlHelpAdapter//帮助
    override fun getFragmentLayoutId(): Int = R.layout.fragment_personl

    override fun init(view: View?) {
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
                   AllOrderActivity.startAllOrderActivity(context!!)
               }
               1->{
                   NotReviewOrderActivity.startNotReviewOrderActivity(context!!)
               }
               2->{
                   NotGoodsOrderActivity.startNotGoodsOrderActivity(context!!)
               }
               3->{
                   CompleteOrderActivity.startCompleteOrderActivity(context!!)
               }
               4->{
                   CancalOrderActivity.startCancalOrderActivity(context!!)
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
                    AskQuestionActivity.startAskQuestionActivity(context!!)
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





    }
}