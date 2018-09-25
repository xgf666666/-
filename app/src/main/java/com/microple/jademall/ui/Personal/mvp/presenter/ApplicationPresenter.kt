package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.ApplicationContract
import com.microple.jademall.ui.Personal.mvp.model.ApplicationModel
import com.microple.jademall.uitls.showToast
import com.weibiaogan.bangbang.common.isPhone
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ApplicationPresenter:ApplicationContract.Presenter() {
    override fun getImage(upload_img: String) {
        getModel().getImage(upload_img).ui({
            getView()?.getImage(it.data!!)
        },{
            getView()?.showToast(it.message)
        })
    }

    override fun apply(token: String, supplier_name: String, email: String, phone: String, inviter: String, license: String, attach: String) {
        if (supplier_name.isNullOrEmpty()){
            getView()?.showToast("请输入公司名称")
            getView()?.dismissLoadingDialog()
            return
        }else if (email.isNullOrEmpty()){
            getView()?.showToast("请输入邮箱地址")
            getView()?.dismissLoadingDialog()
            return
        }else if (phone.isNullOrEmpty()){
            getView()?.showToast("请输入联系方式")
            getView()?.dismissLoadingDialog()
            return
        }else if (!inviter.isPhone()){
            getView()?.showToast("请输入邀请人手机号")
            getView()?.dismissLoadingDialog()
            return
        }else if (license.isNullOrEmpty()){
            getView()?.showToast("请上传营业执照")
            getView()?.dismissLoadingDialog()
            return
        }else if (attach.isNullOrEmpty()){
            getView()?.showToast("请上传附件")
            getView()?.dismissLoadingDialog()
            return
        }
        getModel().apply(token,supplier_name,email,phone,inviter,license,attach).ui({
            getView()?.apply(it.msg!!)
        },{
            getView()?.dismissLoadingDialog()
            getView()?.showToast(it)
        })
    }

    override fun createModel(): ApplicationContract.Model =ApplicationModel()
}