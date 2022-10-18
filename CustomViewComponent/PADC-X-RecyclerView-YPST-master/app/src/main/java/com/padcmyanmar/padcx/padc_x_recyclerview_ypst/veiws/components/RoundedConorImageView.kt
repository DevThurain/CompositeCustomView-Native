package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView

class RoundedConorImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attrs) {
        val conorRadius = 32f
    var path = Path()

    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF( 0f,  0f,width.toFloat(),  height.toFloat())
        path.addRoundRect(rectangle, conorRadius, conorRadius, Path.Direction.CCW)
        canvas?.clipPath(path)
        super.onDraw(canvas)
    }
}