package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.delegates.RetryDelegate
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.views.MainView

interface MainPresenter : NewsItemDelegate, BasePresenter<MainView>, RetryDelegate {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
    fun onTapFAB()
}
