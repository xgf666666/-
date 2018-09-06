package com.microple.jademall.ui.Personal.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import com.blankj.utilcode.util.EncodeUtils
import com.blankj.utilcode.util.PermissionUtils
import com.microple.jademall.BuildConfig
import com.microple.jademall.R
import com.microple.jademall.bean.Image
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.Personal.mvp.contract.ApplicationContract
import com.microple.jademall.ui.Personal.mvp.presenter.ApplicationPresenter
import com.weibiaogan.bangbang.dialog.ChooseImageDialogWrapper
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseutilslibrary.common.ImageChooseHelper
import kotlinx.android.synthetic.main.activity_application.*
import kotlinx.android.synthetic.main.item_title.*
import java.io.File

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商家入驻申请
 */
class ApplicationActivity : BaseMvpActivity<ApplicationPresenter>(),ApplicationContract.View {


    var license=""//营业执照
    var attach=""//附件
    var index=0
    var flag=0
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): ApplicationPresenter = ApplicationPresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_application

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="商家入驻"
        initImageChooseHelper()
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{
            finish()
        }
        tv_submint.setOnClickListener{
            showLoadingDialog()
            if (!license.isNullOrEmpty()&&!attach.isNullOrEmpty())
            getPresenter().getImage(license)
        }
        rl_yingye.setOnClickListener {
            index=1
            showEditAvatarDialog()
        }

        rl_fujian.setOnClickListener{
            index=2
            showEditAvatarDialog()
        }
    }

    override fun apply(msg: String) {
        dismissLoadingDialog()
        showToast(msg)
        finish()
    }
    override fun getImage(image: Image) {
        if (flag==0){
            flag++
            license=image.image_data
            getPresenter().getImage(attach)
        }else{
            attach=image.image_data
            getPresenter().apply(Constants.getToken(),et_gongsi.text.toString(),et_email.text.toString(),
                    et_phone.text.toString(),et_invite.text.toString(),license,attach)

        }


    }
    companion object {
        fun startApplicationActivity(context: Context){
            val intent = Intent(context,ApplicationActivity::class.java)
            context.startActivity(intent)
        }
    }
    private lateinit var imageChooseHelper: ImageChooseHelper
    private fun initImageChooseHelper(){
        imageChooseHelper = ImageChooseHelper.Builder()
                .setUpActivity(this)
                .setAuthority("${BuildConfig.APPLICATION_ID}.fileprovider")//设置文件提供者
                .setDirPath(Environment.getExternalStorageDirectory().absolutePath + "/" + BuildConfig.APPLICATION_ID)//设置文件存储路径
                .isCrop(false)//开启裁剪
                .setCompressQuality(100)//压缩质量[1,100]
                .setSize(200, 180)//裁剪尺寸
                .setOnFinishChooseImageListener{ uri: Uri?, file: File? ->
                    var  bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri)
                    if (index==1){
                        license= EncodeUtils.base64Encode2String(file?.readBytes())
                        iv_yingye.setImageBitmap(bitmap)
                        iv_add_yingye.visibility= View.GONE
                    }else if (index==2){
                        attach= EncodeUtils.base64Encode2String(file?.readBytes())
                        iv_fujian.setImageBitmap(bitmap)
                        iv_add_fujian.visibility=View.GONE
                    }

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
