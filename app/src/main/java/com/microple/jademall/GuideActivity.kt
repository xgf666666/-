package com.microple.jademall

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.home.fragment.*
import kotlinx.android.synthetic.main.activity_guide.*

class GuideActivity : AppCompatActivity() {
    var imgs = arrayListOf(GuideOneFragment(), GuideTwoFragment(), GuideThreeFragment(), GuideFourFragment(), GuideFiveFragment())
    var text: List<TextView>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        text = arrayListOf<TextView>(tv_one, tv_two, tv_three, tv_four, tv_five)
        initView()
    }

    private fun initView() {
        Constants.setNotFirst()
        viewPager.adapter = MyPagerAdapter(supportFragmentManager, imgs)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        (imgs[0] as GuideOneFragment).setAnim()
                    }
                    1 -> {
                        (imgs[1] as GuideTwoFragment).setAnim()
                    }
                    2 -> {
                        (imgs[2] as GuideThreeFragment).setAnim()
                    }
                    3 -> {
                        (imgs[3] as GuideFourFragment).setAnim()
                    }
                    4 -> {
                        (imgs[4] as GuideFiveFragment).setAnim()
                    }

                }
                for (i in 0..text!!.size - 1) {
                    text!![i].setBackground(resources.getDrawable(R.drawable.bg_guide_two))
                }
                text!![position].setBackground(resources.getDrawable(R.drawable.bg_guide))
            }
        })

    }

    class MyPagerAdapter(fm: FragmentManager, val datas: List<Fragment>) : FragmentPagerAdapter(fm) {
        /**
         * Return the Fragment associated with a specified position.
         */
        override fun getItem(position: Int): Fragment = datas[position]


        override fun getCount(): Int = datas.size


    }

    companion object {
        fun startGuideActivity(context: Context) {
            val intent = Intent(context, GuideActivity::class.java)
            context.startActivity(intent)
        }
    }

}
