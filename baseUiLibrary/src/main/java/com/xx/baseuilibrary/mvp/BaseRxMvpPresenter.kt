package com.xx.baseuilibrary.mvp

import com.xx.baseutilslibrary.network.rx.RxHttpObserver
import org.jetbrains.annotations.NotNull
import java.lang.ref.WeakReference
import java.util.*

/**
 * BaseMvpPresenter
 * (。・∀・)ノ
 * Describe：使用RxJava处理网络请求时使用
 * Created by 雷小星🍀 on 2017/10/31 9:37.
 */

abstract class BaseRxMvpPresenter<M, V : BaseMvpView> {

    private var vWeakReference: WeakReference<V>? = null
    private var model: M? = null

    /**
     * 接口加载状态
     */
    var isLoading: Boolean? = false

    private var observableList: MutableList<RxHttpObserver<*>>? = null

    /**
     * 关联指定Observer
     */
    fun attachObserver(observable: RxHttpObserver<*>) {
        if (observableList == null) {
            observableList = ArrayList()
        }
        if (!observableList!!.contains(observable)) {
            observableList!!.add(observable)
        }
    }

    /**
     * 解除指定关联的Observer
     *
     * @param observable Observer
     */
    fun detachObserver(observable: RxHttpObserver<*>) {
        if (observableList != null) {
            observable.cannel()
            observableList!!.remove(observable)
        }
    }

    /**
     * 解除所有关联Observer
     */
    fun detachAllObserver() {
        if (observableList != null) {
            for (observable in observableList!!) {
                observable.cannel()
            }
            observableList!!.clear()
            observableList = null
        }
    }


    fun detachView() {
        detachAllObserver()
        if (vWeakReference != null) {
            vWeakReference!!.clear()
            vWeakReference = null
        }
    }

    /**
     * 获取V实例
     */
    protected fun getView(): V? {
        return if (vWeakReference == null) null else vWeakReference!!.get()
    }

    protected fun getModel(): M {
        return model ?: createModel()
    }


    @NotNull
    protected abstract fun createModel(): M
}
