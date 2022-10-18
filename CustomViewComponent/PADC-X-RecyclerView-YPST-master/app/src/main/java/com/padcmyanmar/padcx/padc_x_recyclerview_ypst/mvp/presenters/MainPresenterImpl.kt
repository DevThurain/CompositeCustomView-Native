package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.models.NewsModelImpl
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mNewsModel = NewsModelImpl

    override fun onTapNewsItem(newsId: Int) {
        mView?.navigateToNewsDetails(newsId)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestAllNews(lifecycleOwner)
    }

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllNews(lifeCycleOwner)
    }

    override fun onTapFAB() {
        mView?.navigateToModifyCustomView()
    }

    private fun requestAllNews(lifeCycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mNewsModel.getAllNews(onError = {
            mView?.disableSwipeRefresh()
            mView?.displayEmptyView()
        }).observe(lifeCycleOwner, Observer {
            mView?.disableSwipeRefresh()
            if (it.isEmpty()) mView?.displayEmptyView() else mView?.displayNewsList(it)
        })
    }


    override fun onTapLike() {
        Log.d("reaction","tap like")
    }

    override fun onTapComment() {
        Log.d("reaction","tap comment")
    }

    override fun onTapShare() {
        Log.d("reaction","tap share")
    }

    override fun onRetry() {
        Log.d("retry","tap retry")
        loadAllNewsFromApi()
    }

    private fun loadAllNewsFromApi(){
        mNewsModel.getAllNewsFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
    }
}