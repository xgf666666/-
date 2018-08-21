package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import com.flyco.dialog.listener.OnOperItemClickL
import com.flyco.dialog.widget.ActionSheetDialog
import com.microple.jademall.R
import com.microple.jademall.dialog.TextDialog
import com.microple.jademall.weight.ZoomScrollView
import kotlinx.android.synthetic.main.activity_goods.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商品详情
 */
class GoodsDetailActivity : AppCompatActivity() {
    companion object {
        fun startGoodsDetailActivity(context: Context){
            val intent = Intent(context, GoodsDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)
        tv_sure.setOnClickListener{
            PaySucceefulActivity.startPaySucceefulActivity(this)
        }
        tv_jifen.setOnClickListener{
            var dialog=TextDialog(this)
            dialog.show()
            dialog.setOnBtnClickListener {
                dialog.dismiss()
            }
        }
        tv_other.setOnClickListener{
            showChangeSexDialogOne()
        }
        iv_zoom.setOnClickListener{
            ImageDetailActivity.startImageDetailActivity(this)
        }
    }
    private fun showChangeSexDialogOne() {
        val items=Array<String>(4,{"12233"})
//        for (s in 0 ..(datas.size-1)){
//            items.set(s,datas.get(s).area_name)
//        }

        val dialog = ActionSheetDialog(this, items, null).isTitleShow(false)
        dialog.titleTextColor(resources.getColor(R.color.black_333333))
        dialog.title("选择其他编号")
        dialog.isTitleShow(true)
        dialog.setOnOperItemClickL(object : OnOperItemClickL {
            override fun onOperItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                dialog.dismiss()
            }
        })
        dialog.show()
    }

}
