package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.ViewPagerAdapter
import com.microple.jademall.ui.Personal.fragment.AllOrderFramgent
import kotlinx.android.synthetic.main.activity_all_order.*
import kotlinx.android.synthetic.main.item_title.*

/**
* author: xiaoguagnfei
* date: 2018/8/13
* describe:我的订单
*/
class AllOrderActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    companion object {
        fun startAllOrderActivity(context: Context){
            val intent = Intent(context,AllOrderActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_order)
        tv_title.text="我的订单"
        var fragmentManager: FragmentManager =supportFragmentManager
        var fragmentList=ArrayList<Fragment>()
        fragmentList.add(AllOrderFramgent())
        fragmentList.add(AllOrderFramgent())
        fragmentList.add(AllOrderFramgent())
        fragmentList.add(AllOrderFramgent())
        fragmentList.add(AllOrderFramgent())
        fragmentList.add(AllOrderFramgent())
        fragmentList.add(AllOrderFramgent())
        var adapter=ViewPagerAdapter(fragmentManager,fragmentList)
        viewPager.adapter=adapter
        viewPager.setOnPageChangeListener(this)
        iv_back.setOnClickListener{
            finish()
        }
        tv_allOrder.setOnClickListener{
            setText(tv_allOrder)
            viewPager.setCurrentItem(0)
        }
        tv_daishenhe.setOnClickListener{
            setText(tv_daishenhe)
            viewPager.setCurrentItem(1)
        }
        tv_daifahuo.setOnClickListener{
            setText(tv_daifahuo)
            viewPager.setCurrentItem(2)
        }
        tv_daishouhuo.setOnClickListener{
            setText(tv_daishouhuo)
            viewPager.setCurrentItem(3)
        }
        tv_exit.setOnClickListener{
            setText(tv_exit)
            viewPager.setCurrentItem(4)

        }
        tv_complete.setOnClickListener{
            setText(tv_complete)
            viewPager.setCurrentItem(5)

        }
        tv_shouhou.setOnClickListener{
            setText(tv_shouhou)
            viewPager.setCurrentItem(6)

        }

    }
    fun setText(textView:TextView){
        tv_allOrder.textSize=13f
        tv_daishenhe.textSize=13f
        tv_daifahuo.textSize=13f
        tv_daishouhuo.textSize=13f
        tv_complete.textSize=13f
        tv_exit.textSize=13f
        tv_shouhou.textSize=13f
        tv_allOrder.setTextColor(resources.getColor(R.color.black_333333))
        tv_daishenhe.setTextColor(resources.getColor(R.color.black_333333))
        tv_daifahuo.setTextColor(resources.getColor(R.color.black_333333))
        tv_daishouhuo.setTextColor(resources.getColor(R.color.black_333333))
        tv_exit.setTextColor(resources.getColor(R.color.black_333333))
        tv_shouhou.setTextColor(resources.getColor(R.color.black_333333))
        tv_complete.setTextColor(resources.getColor(R.color.black_333333))
        textView.setTextColor(resources.getColor(R.color.green_06A366))
        textView.textSize=16f
    }
    override fun onPageScrollStateChanged(state: Int) {
    }


    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }


    override fun onPageSelected(position: Int) {
        when(position){
            0->{
                setText(tv_allOrder)
            }
            1->{
                setText(tv_daishenhe)

            }
            2->{
                setText(tv_daifahuo)
            }
            3->{
                setText(tv_daishouhuo)
            }
            4->{
                setText(tv_complete)
                scrollView.pageScroll(4)
            }
            5->{
                setText(tv_exit)
                scrollView.pageScroll(5)

            }
            6->{
                setText(tv_shouhou)
                scrollView.pageScroll(6)

            }
        }
    }

}
