package com.microple.jademall.ui.Personal.adapter
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.MyAppointment

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class MyAppointmentAdapter(data:List<MyAppointment.RecentAppointBean>):BaseQuickAdapter<MyAppointment.RecentAppointBean,BaseViewHolder>(R.layout.item_myappointment,data) {

    override fun convert(helper: BaseViewHolder?, item: MyAppointment.RecentAppointBean) {
//        if (helper?.adapterPosition==0){
//            helper?.getView<TextView>(R.id.tv_start).visibility=View.VISIBLE
//            helper?.setText(R.id.tv_start,"近期开始")
//        }
        helper?.setText(R.id.tv_name,item.live_title)
                ?.setText(R.id.tv_time_zhibo,item.start_time)
                ?.setText(R.id.tv_content,item.desc)
        helper?.addOnClickListener(R.id.tv_exit)

    }
}