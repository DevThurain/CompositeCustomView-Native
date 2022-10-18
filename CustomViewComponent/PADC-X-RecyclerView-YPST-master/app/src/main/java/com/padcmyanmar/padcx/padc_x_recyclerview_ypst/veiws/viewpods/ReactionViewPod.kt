package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.delegates.ReactionDelegate
import kotlinx.android.synthetic.main.view_pod_reaction.view.*

class ReactionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    lateinit var reactionDelegate: ReactionDelegate
    override fun onFinishInflate() {
        super.onFinishInflate()
        setupListeners()
    }

    fun setupViewpod(delegate: ReactionDelegate){
        reactionDelegate = delegate
    }

    fun setupListeners(){
        llLike.setOnClickListener {
            reactionDelegate.onTapLike()
        }

        llComment.setOnClickListener {
            reactionDelegate.onTapComment()
        }

        llShare.setOnClickListener {
            reactionDelegate.onTapShare()
        }
    }
}