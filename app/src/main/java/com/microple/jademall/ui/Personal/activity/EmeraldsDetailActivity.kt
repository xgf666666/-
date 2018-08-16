package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import com.flyco.dialog.listener.OnBtnClickL
import com.flyco.dialog.widget.NormalDialog
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_orderdetail_two.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:翡翠订单详情
 */
class EmeraldsDetailActivity : AppCompatActivity() {
    companion object {
        fun startOrderDetailActivity(context: Context){
            val intent = Intent(context,EmeraldsDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderdetail_two)
        tv_title.text="订单详情"
        tv_shouyi.setOnClickListener{
            IntergrationGetActivity.startEmeraldsDetailActivity(this)
        }
        tv_tihuo.setOnClickListener{
            PickGoodsActivity.startPickGoodsActivity(this)
        }
        tv_jifen.setOnClickListener{
            showDialog(this,"30000")
        }
    }
    fun showDialog(context: Context,msg:String){
        var dialog = NormalDialog(context)
        dialog.style(NormalDialog.STYLE_TWO)
                .content(msg)
                .title("积分兑换")
                .style(NormalDialog.STYLE_TWO)
                .contentTextSize(17f)
                .titleTextSize(17f)
                .contentTextColor(context.resources.getColor(R.color.black_444444))
                .titleTextColor(context.resources.getColor(R.color.black_333333))
                .btnNum(2)
                .btnText("确定","取消")
                .btnTextColor(context.resources.getColor(R.color.color3078EF))
                .setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
        dialog.setOnBtnClickL(OnBtnClickL {
            dialog.dismiss()
        }, OnBtnClickL {
            dialog.dismiss()
        })
    }
}
