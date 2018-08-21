package com.microple.jademall.ui.Personal.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.blankj.utilcode.util.PermissionUtils
import com.microple.jademall.BuildConfig
import com.microple.jademall.R
import com.microple.jademall.ui.home.activity.ImageDetailActivity
import com.weibiaogan.bangbang.dialog.ChooseImageDialogWrapper
import com.xx.baseutilslibrary.common.ImageChooseHelper
import kotlinx.android.synthetic.main.activity_personal_setting.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:个人资料设置
 */
class PersonalSettingActivity : AppCompatActivity() {
    private lateinit var imageChooseHelper: ImageChooseHelper

    companion object {
        fun startPersonalSettingActivity(context: Context){
            val intent = Intent(context, PersonalSettingActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_setting)
        tv_title.text="个人资料设置"
        initImageChooseHelper()
        rl_name.setOnClickListener{
            NickNameActivity.startNickNameActivity(this)
        }
        rl_hand.setOnClickListener{
            showEditAvatarDialog()
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

}
