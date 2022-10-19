package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components.EmotionalFaceView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.StateProgressViewPod
import kotlinx.android.synthetic.main.activity_modify_custom_view.*

class ModifyCustomViewActivity: BaseActivity() {
    companion object{
        fun getIntent(context: Context): Intent{
            return Intent(context, ModifyCustomViewActivity::class.java)
        }
    }
    private lateinit var mViewPodStateProgress: StateProgressViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_custom_view)

        setUpViewPod()
        setupListeners()
    }

    private fun setUpViewPod() {
        mViewPodStateProgress = viewPodStateProgress as StateProgressViewPod
        mViewPodStateProgress.apply {
            setStepDescription("Survey", "Cabling", "Splicing", "Activate")
        }
    }

    fun setupListeners(){
         // 1
        btnHappy.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
        }

        // 2
        btnSad.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.SAD
        }


        btn1.setOnClickListener {
            mViewPodStateProgress.onTapStep1()
        }

        btn2.setOnClickListener {
            mViewPodStateProgress.onTapStep2()
        }

        btn3.setOnClickListener {
            mViewPodStateProgress.onTapStep3()
        }

        btn4.setOnClickListener {
            mViewPodStateProgress.onTapStep4()
            mViewPodStateProgress.completeAllSteps()
        }
    }
}