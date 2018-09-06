package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Note
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.NeedNoteContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class NeednoteModel: NeedNoteContract.Model {
    override fun getNoteContent(token: String): Observable<BaseResponseEntity<Note>> =AppApi.Api().getNote(token)

}