package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microple.jademall.BuildConfig
import com.microple.jademall.R
import com.microple.jademall.bean.Share
import com.microple.jademall.common.Constants
import com.microple.jademall.dialog.ShareDialog
import com.microple.jademall.ui.Personal.mvp.contract.ShareContract
import com.microple.jademall.ui.Personal.mvp.presenter.SharePresenter
import com.microple.jademall.uitls.loadImag
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMWeb
import com.umeng.socialize.shareboard.SnsPlatform
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.contract.BaseMvpRecycleViewContract
import kotlinx.android.synthetic.main.activity_share.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:分享
 */
class ShareActivity : BaseMvpActivity<SharePresenter>(),ShareContract.View {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SharePresenter = SharePresenter()

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_share

    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text="分享"
        getPresenter().getShare(Constants.getToken())
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
        iv_share.setOnClickListener {
            var dialog= ShareDialog(this)
            dialog.show()
            dialog.setOnBtnClickListener(object : ShareDialog.OnBtnClickListener {
                override fun QQShare() {
                    share(SHARE_MEDIA.QQ.toSnsPlatform())
                }

                override fun weiboShare() {
                    share(SHARE_MEDIA.SINA.toSnsPlatform())

                }

                override fun wxShare() {
                    share(SHARE_MEDIA.WEIXIN.toSnsPlatform())

                }

                override fun wxwcShare() {
                    share(SHARE_MEDIA.WEIXIN_CIRCLE.toSnsPlatform())

                }

                override fun cancel() {
                    dialog.dismiss()

                }

            })

        }
    }
        var share: Share?=null
    override fun getShare(share: Share) {
        this.share=share
        loading.visibility=View.GONE
        tv_head.text=share.share_info.user_name
        iv_erweima.loadImag(share.share_info.qrcode)
        tv_yaoqingma.text=share.share_info.code
        tv_web.text=share.share_info.link
    }

    companion object {
        fun startShareActivityMerchantEntryActivity(context: Context){
            val intent = Intent(context,ShareActivity::class.java)
            context.startActivity(intent)
        }
    }
    private fun share(platform: SnsPlatform){
        if (share!=null){
            var web = UMWeb(share?.share_info?.link)
            web.setTitle(share?.share_info?.user_name)
            web.setThumb( UMImage(this, BuildConfig.DEV_DOMAIN+"/api/"+share?.share_info?.head_img))
            web.setDescription(share?.share_info?.qrcode)
            ShareAction(this)
                    .withMedia(web)
                    .setPlatform(platform.mPlatform)
                    .setCallback(umShareListener).share()
        }else{
            showToast("没有分享内容")
        }
    }
    private var umShareListener= object : UMShareListener {
        override fun onResult(p0: SHARE_MEDIA?) {
            showToast("分享成功")
        }

        override fun onCancel(p0: SHARE_MEDIA?) {
            showToast("分享取消")
        }

        override fun onError(p0: SHARE_MEDIA?, p1: Throwable?) {
            showToast("分享失败")
        }

        override fun onStart(p0: SHARE_MEDIA?) {
        }
    }


}
