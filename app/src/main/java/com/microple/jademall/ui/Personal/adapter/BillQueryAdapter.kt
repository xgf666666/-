package com.microple.jademall.ui.Personal.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.PointBean

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class BillQueryAdapter(data:List<PointBean>):BaseQuickAdapter<PointBean,BaseViewHolder>(R.layout.item_billquery,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: PointBean?) {
        if (item?.getHas()!!){
            helper?.getView<TextView>(R.id.tv_year)?.visibility=View.VISIBLE
            helper?.getView<TextView>(R.id.tv_month)?.visibility=View.VISIBLE
        }else{
            helper?.getView<TextView>(R.id.tv_year)?.visibility=View.GONE
            helper?.getView<TextView>(R.id.tv_month)?.visibility=View.GONE
        }
        helper?.setText(R.id.tv_name,item.text)
                ?.setText(R.id.tv_time,item.add_time)

                ?.setText(R.id.tv_month,item.month)
                ?.setText(R.id.tv_year,item.year)
        if (item?.type==1){
            helper?.setText(R.id.tv_zichan,"+"+item.points_change+"  积分")
        }else{
            helper?.setText(R.id.tv_zichan,"-"+item.points_change+"  积分")
        }

    }


}