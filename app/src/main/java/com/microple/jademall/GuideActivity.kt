package com.microple.jademall

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.microple.jademall.common.Constants
import kotlinx.android.synthetic.main.activity_guide.*

class GuideActivity : AppCompatActivity() {
    var imgs= arrayListOf(R.drawable.img_guidepage_one,R.drawable.img_guidepage_two,R.drawable.img_guidepage_three,R.drawable.img_guidepage_four,R.drawable.img_guidepage_five)
    var imgList = arrayListOf<ImageView>()
    var text:List<TextView>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        text= arrayListOf<TextView>(tv_one,tv_two,tv_three,tv_four,tv_five)
        initView()
    }

    private fun initView() {
        Constants.setNotFirst()
        for (i in 0..imgs.size-1){
            var imageView=ImageView(this)
            imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            imageView.setImageResource(imgs[i])
            imgList.add(imageView)
            if (i==4){
                imageView.setOnClickListener {
                    MainActivity.startMainActivity(this)
                    finish()
                }
            }
        }
        viewPager.adapter=MyPagerAdapter(imgList)
        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0..text!!.size-1){
                    text!![i].setBackground(resources.getDrawable(R.drawable.bg_guide_two))
                }
                text!![position].setBackground(resources.getDrawable(R.drawable.bg_guide))
            }
        })

    }
    class MyPagerAdapter(val datas : List<ImageView>) : PagerAdapter(){
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int = datas.size

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            container.addView(datas[position])
            return datas[position]
        }

    }
    companion object {
        fun startGuideActivity(context: Context){
            val intent = Intent(context, GuideActivity::class.java)
            context.startActivity(intent)
        }
    }

}
