package com.microple.jademall.ui.Personal.mvp.presenter

import android.text.TextUtils
import android.util.Log
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.IntergrationPushContract
import com.microple.jademall.ui.Personal.mvp.model.IntergrationPushModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class IntergrationPushPresenter:IntergrationPushContract.Presenter() {
    override fun getAccout(token: String) {
        getModel().getAccout(token).ui({
            getView()?.getAccout(it.data!!)
        },{
            getView()?.showToast(it)
        })

    }

    override fun push(token: String, to_user: String, points: String,frozen_points:String) {
        if (TextUtils.isEmpty(to_user)){
            getView()?.showToast("请输入对方账号")
            getView()?.dismissLoadingDialog()
            return
        }
        if (TextUtils.isEmpty(points)){
            getView()?.showToast("请输入转账积分")
            getView()?.dismissLoadingDialog()
            return
        }
        if (to_user.equals(Constants.getPersonal().phone)){
            getView()?.showToast("不能给自己转哦")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().push(token,to_user,points,frozen_points).ui({
            getView()?.push()
        },{
            getView()?.showToast(it)
            getView()?.dismissLoadingDialog()

        })
    }

    override fun createModel(): IntergrationPushContract.Model =IntergrationPushModel()
}