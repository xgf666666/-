package com.microple.jademall.ui.Personal.mvp.presenter

import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.IntergrationGetContract
import com.microple.jademall.ui.Personal.mvp.model.AboutMelModel
import com.microple.jademall.ui.Personal.mvp.model.IntergrationGetModel

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class IntergrationGetPresenter:IntergrationGetContract.Presenter() {
    override fun createModel(): IntergrationGetContract.Model =IntergrationGetModel()
}