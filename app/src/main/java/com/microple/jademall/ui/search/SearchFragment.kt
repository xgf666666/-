package com.microple.jademall.ui.search

import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.MainActivity
import com.microple.jademall.R
import com.microple.jademall.bean.Search
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.search.activity.SearchResultGoodsActivity
import com.microple.jademall.ui.search.activity.SearchSortGoodsActivity
import com.microple.jademall.ui.search.adapter.SearchSortAdapter
import com.microple.jademall.ui.search.mvp.contract.SearchContract
import com.microple.jademall.ui.search.mvp.presenter.SearchPresenter
import com.microple.jademall.uitls.loadHeadImag
import com.xx.baseuilibrary.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_tool_bar.*

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:搜索
 */
class SearchFragment : BaseMvpFragment<SearchContract.Model,SearchContract.View,SearchPresenter>(),SearchContract.View,BaseQuickAdapter.OnItemClickListener, TextView.OnEditorActionListener {


    var search:Search?=null
    var hotToData:ArrayList<Search.CategorysBean>?=null
    var histroyData:ArrayList<Search.CategorysBean>?=null

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SearchPresenter =SearchPresenter()


    private var mAdapter = SearchSortAdapter(R.layout.item_search_sort)

    override fun getFragmentLayoutId(): Int = R.layout.fragment_search
    override fun getSearch(data: Search) {
        hotToData= ArrayList()
        search=data
        if (data!=null){
            mAdapter.setNewData(data.categorys)
        }
        for (i in 0..data.hot_keys.size-1){
            var hot=Search.CategorysBean()
            hot.name=data.hot_keys[i].keyword
            hotToData?.add(hot)
        }
    }
    override fun init(view: View?) {
        iv_head.setOnClickListener {
            (activity as MainActivity).setSelect(4)
        }

        if (Constants.isLogin()){
            iv_head.loadHeadImag(Constants.getHeadImg())
        }else{
            iv_head.setImageResource(R.drawable.datouxiang_)
        }
        getPresenter().getSearch()
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter
        mAdapter.setOnItemClickListener(this)
        recyclerView.isNestedScrollingEnabled=false
        scrollView.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            if (scrollY>=90){
                tv_title.visibility=View.VISIBLE
                tv_title.text="搜索"
            }else{
                tv_title.visibility=View.GONE
            }
        }
        tv_classify.setOnClickListener{
            setText(tv_classify,1)
        }
        tv_hot.setOnClickListener{
            setText(tv_hot,2)
        }
        tv_history.setOnClickListener{
            setText(tv_history,3)
        }
        et_search.setOnEditorActionListener(this)


    }
    override fun onEditorAction(v: TextView?, actionId: Int, p2: KeyEvent?): Boolean {
        if (actionId==EditorInfo.IME_ACTION_SEARCH){
            if (Constants.getSearch().isNullOrEmpty()){
                Constants.putSearch(v?.text.toString())
            }else{

                Constants.putSearch(Constants.getSearch()+","+v?.text.toString())

            }
            if (v?.text.toString().isNullOrEmpty()){
                    showToast("请输入关键字")
            }else{
                SearchResultGoodsActivity.startSearchResultGoodsActivity(context!!,v?.text.toString())
            }
            return true
        }

        return false
    }
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        if ((adapter as SearchSortAdapter).data[position].cat_id==0){
            SearchResultGoodsActivity.startSearchResultGoodsActivity(context!!,adapter.data[position].name)
        }else{
            SearchSortGoodsActivity.startSearchSortGoodsActivity(context!!,adapter.data[position].cat_id,adapter.data[position].name)
        }
    }
    fun setText(textView: TextView,flag:Int){
        tv_classify.textSize=13f
        tv_hot.textSize=13f
        tv_history.textSize=13f
        tv_hot.isEnabled=true
        tv_history.isEnabled=true
        tv_classify.isEnabled=true
        tv_classify.setTextColor(resources.getColor(R.color.black_333333))
        tv_hot.setTextColor(resources.getColor(R.color.black_333333))
        tv_history.setTextColor(resources.getColor(R.color.black_333333))
        textView.setTextColor(resources.getColor(R.color.green_06A366))
        textView.textSize=16f
        textView.isEnabled=false
        if (search!=null){
            if (flag==1){
                mAdapter.setNewData(search?.categorys)
            } else if (flag==2){
                mAdapter.setNewData(hotToData)
            }else if (flag==3){
                if (!Constants.getSearch().isNullOrEmpty()){
                    var item=Constants.getSearch().split(",")
                    histroyData=ArrayList()
                    for ( i in 0..item.size-1){
                        var history=Search.CategorysBean()
                        history.name=item[i]
                        histroyData?.add(history)
                    }
                }
                mAdapter.setNewData(histroyData)

            }
            mAdapter.notifyDataSetChanged()
        }
    }
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden){
            if (Constants.isLogin()){
                iv_head.loadHeadImag(Constants.getPersonal().head_img)
            }else{
                iv_head.setImageResource(R.drawable.datouxiang_)
            }
        }
    }

}