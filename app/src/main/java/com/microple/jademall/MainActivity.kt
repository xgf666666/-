package com.microple.jademall

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.util.Log
import android.view.ContextMenu
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import com.blankj.utilcode.util.ActivityUtils
import com.microple.jademall.common.App
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.PersonlFragment
import com.microple.jademall.ui.Personal.activity.LoginActivity
import com.microple.jademall.ui.home.HomeFragment
import com.microple.jademall.ui.live.LiveFragment
import com.microple.jademall.ui.search.SearchFragment
import com.microple.jademall.ui.shoppingcar.ShoppingCarFragment
import com.microple.jademall.uitls.BottomNavigationViewUtils
import com.tencent.imsdk.TIMManager
import com.tencent.imsdk.TIMSdkConfig
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseMvpViewActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    /**
     * 初始化数据状态
     */
    override fun initData() {
        //改变状态字体为深色
        (application as App).addActivity(this)
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.linearLayout, mFragments[0])
                .commit()
        BottomNavigationViewUtils.disableShiftMode(bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }


    override fun getActivityLayoutId(): Int = R.layout.activity_main

    private var mFragments: Array<Fragment?> = arrayOf(HomeFragment(), null, null, null, null)
    private val mMenuItemId = arrayOf(R.id.item0, R.id.item1, R.id.item2, R.id.item3, R.id.item4)

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.navigation_main, menu)
    }

    /**
     * Fragemnt切换
     */
    fun selectedFragemnt(itemId: Int, bundle: Bundle?) {
        if (bundle != null) {
            bottomNavigationView.selectedItemId = itemId
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        for (i in mFragments.indices) {
            val fragment = mFragments[i]
            if (mMenuItemId[i] == itemId) {
                //先检查Fragment是否创建
                if (fragment == null) {
                    when (i) {
                        0 -> mFragments[i] = HomeFragment()
                        1 -> mFragments[i] = LiveFragment()
                        2 -> mFragments[i] = SearchFragment()
                        3 -> mFragments[i] = ShoppingCarFragment()
                        4 -> mFragments[i] = PersonlFragment()
                    }
                    //添加到管理类
                    fragmentTransaction.add(R.id.linearLayout, mFragments[i])
                }
                mFragments[i]?.arguments = bundle
                fragmentTransaction.show(mFragments[i])
            } else {
                if (fragment != null) {
                    fragmentTransaction.hide(fragment)
                }
            }
        }
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        selectedFragemnt(item.itemId, null)
        return true
    }
    companion object {
        fun startMainActivity(context: Context){
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    /**
     * 双击返回桌面
     */
    var isExit: Boolean? = false//是否退出登录
    private fun back2exit() {
        if (isExit!!) {
           finish()
        }
        isExit = true
        showToast("再按一次回到桌面")
        Timer().schedule(object : TimerTask() {
            override fun run() {
                isExit = false
            }

        }, 1500)
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back2exit()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        super.onDestroy()
        (application as App).deleteActivity(this)
    }


}
