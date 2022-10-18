package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R

class RoundedConorImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attrs) {
        var conorRadius = 0f
    var path = Path()

    init {
        context.withStyledAttributes(attrs, R.styleable.RoundedConorImageView){
            conorRadius = getDimension(R.styleable.RoundedConorImageView_cornerRadius, 0f)
        }
    }
    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF( 0f,  0f,width.toFloat(),  height.toFloat())
        path.addRoundRect(rectangle, conorRadius, conorRadius, Path.Direction.CCW)
        canvas?.clipPath(path)
        super.onDraw(canvas)
    }
}