package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components.EmotionalFaceView
import kotlinx.android.synthetic.main.activity_modify_custom_view.*

class ModifyCustomViewActivity: BaseActivity() {
    companion object{
        fun getIntent(context: Context): Intent{
            return Intent(context, ModifyCustomViewActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_custom_view)

        setupListeners()
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
    }
}