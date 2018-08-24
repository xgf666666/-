package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.IntergrationPushContract
import com.microple.jademall.ui.Personal.mvp.model.IntergrationPushModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class IntergrationPushPresenter:IntergrationPushContract.Presenter() {
    override fun createModel(): IntergrationPushContract.Model =IntergrationPushModel()
}