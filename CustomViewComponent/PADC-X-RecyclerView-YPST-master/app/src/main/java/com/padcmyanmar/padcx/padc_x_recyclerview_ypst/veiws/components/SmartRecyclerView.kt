package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SmartRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RecyclerView(context, attrs) {

    var mEmptyView: View? = null

    private val dataObserver = object : AdapterDataObserver(){
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            checkEmpty()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            super.onItemRangeChanged(positionStart, itemCount)
            checkEmpty()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            checkEmpty()
        }

        override fun onChanged() {
            super.onChanged()
            checkEmpty()
        }
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        val oldAdapter = getAdapter()
        oldAdapter?.unregisterAdapterDataObserver(dataObserver)
        super.setAdapter(adapter)

        adapter?.registerAdapterDataObserver(dataObserver)
        checkEmpty()
    }

    fun setEmptyUI(view: View){
        mEmptyView = view
    }


    fun checkEmpty(){
        val isEmpty = adapter!!.itemCount == 0

        mEmptyView?.let {
           it.visibility = if(isEmpty) View.VISIBLE else View.INVISIBLE
            visibility = if (isEmpty) View.INVISIBLE else View.VISIBLE
        }
    }
}