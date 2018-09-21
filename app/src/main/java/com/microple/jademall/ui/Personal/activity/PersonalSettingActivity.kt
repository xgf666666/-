package com.microple.jademall.ui.Personal.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.blankj.utilcode.util.EncodeUtils
import com.blankj.utilcode.util.PermissionUtils
import com.facebook.stetho.inspector.database.ContentProviderSchema
import com.microple.jademall.BuildConfig
import com.microple.jademall.R
import com.microple.jademall.bean.PersonInfo
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.PersonalContract
import com.microple.jademall.ui.Personal.mvp.contract.PersonalSettingContract
import com.microple.jademall.ui.Personal.mvp.presenter.PersonalSettingPresenter
import com.microple.jademall.ui.home.activity.ImageDetailActivity
import com.microple.jademall.uitls.loadImag
import com.weibiaogan.bangbang.dialog.ChooseImageDialogWrapper
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseutilslibrary.common.ImageChooseHelper
import kotlinx.android.synthetic.main.activity_personal_setting.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:个人资料设置
 */
class PersonalSettingActivity : BaseMvpActivity<PersonalSettingPresenter>(),PersonalSettingContract.View {
    override fun setHandImageView(url: String) {
        showToast("修改成功")
        dismissLoadingDialog()

    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): PersonalSettingPresenter = PersonalSettingPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_personal_setting

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="个人资料设置"
        var info=Constants.getPersonal()
//        iv_hand.loadImag(info.head_img)
        initImageChooseHelper()

    }

    override fun onResume() {
        super.onResume()
        var info=Constants.getPersonal()
        tv_name.text=info.user_name
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        rl_name.setOnClickListener{
            NickNameActivity.startNickNameActivity(this)
        }
        rl_hand.setOnClickListener{
            showEditAvatarDialog()
        }
        iv_back.setOnClickListener{
            finish()
        }
    }

    private lateinit var imageChooseHelper: ImageChooseHelper

    companion object {
        fun startPersonalSettingActivity(context: Context){
            val intent = Intent(context, PersonalSettingActivity::class.java)
            context.startActivity(intent)
        }
    }

    private fun initImageChooseHelper(){
        imageChooseHelper = ImageChooseHelper.Builder()
                .setUpActivity(this)
                .setAuthority("${BuildConfig.APPLICATION_ID}.fileprovider")//设置文件提供者
                .setDirPath(Environment.getExternalStorageDirectory().absolutePath + "/" + BuildConfig.APPLICATION_ID)//设置文件存储路径
                .isCrop(true)//开启裁剪
                .setCompressQuality(100)//压缩质量[1,100]
                .setSize(120, 120)//裁剪尺寸
                .setOnFinishChooseAndCropImageListener { bitmap, file ->
                    //                    显示选好得图片
                    iv_hand.setImageBitmap(bitmap)
                    showLoadingDialog()
                    getPresenter().setHandImageView(Constants.getToken(), EncodeUtils.base64Encode2String(file?.readBytes()))
                }
                .create()

    }
    /**
     * 显示修改头像弹窗
     */
    private fun showEditAvatarDialog() {
        //选图弹窗
        //请求相机和内存读取权限
        PermissionUtils.permission(Manifest.permission.CAMERA, Manifest.permission_group.STORAGE)
                .callback(object : PermissionUtils.SimpleCallback {
                    override fun onGranted() {
                        //被给予权限,调起选图弹窗
                        ChooseImageDialogWrapper(imageChooseHelper)
                                .showChooseImage()
                    }

                    override fun onDenied() {
                        //被拒绝
//                        showToast("拒绝给予权限会导致该功能不能正常使用")
                    }
                })
                .rationale { shouldRequest -> shouldRequest.again(true) }
                .request()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            imageChooseHelper.onActivityResult(requestCode, resultCode, data)
    }


}
