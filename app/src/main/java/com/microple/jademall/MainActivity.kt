package com.microple.jademall

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import com.microple.jademall.ui.home.HomeFragment
import com.microple.jademall.uitls.BottomNavigationViewUtils
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpViewActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun getActivityLayoutId(): Int = R.layout.activity_main

    private var mFragments: Array<Fragment?> = arrayOf(HomeFragment(), null, null, null, null)
    private val mMenuItemId = arrayOf(R.id.item0, R.id.item1, R.id.item2, R.id.item3, R.id.item4)

    override fun init() {
        //改变状态字体为深色
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.linearLayout, mFragments[0])
                .commit()
        BottomNavigationViewUtils.disableShiftMode(bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)


    }
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
                        1 -> mFragments[i] = HomeFragment()
                        2 -> mFragments[i] = HomeFragment()
                        3 -> mFragments[i] = HomeFragment()
                        4 -> mFragments[i] = HomeFragment()
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

}
