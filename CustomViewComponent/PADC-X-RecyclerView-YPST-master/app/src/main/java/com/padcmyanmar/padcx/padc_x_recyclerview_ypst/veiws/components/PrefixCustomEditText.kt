package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.provider.CalendarContract
import android.util.AttributeSet
import android.widget.EditText
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R

class PrefixCustomEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatEditText(context, attrs) {
    var mPrefixText = "+95"
    var mPrefixTextColor = Color.BLACK

    val mPrefixRect = Rect()

    init {
        context.withStyledAttributes(attrs, R.styleable.PrefixCustomEditText){
            mPrefixText = getText(R.styleable.PrefixCustomEditText_prefixText).toString()
            mPrefixTextColor = getColor(R.styleable.PrefixCustomEditText_prefixTextColor, mPrefixTextColor)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        paint.getTextBounds(mPrefixText, 0, mPrefixText.length, mPrefixRect)
        mPrefixRect.right = mPrefixRect.right + paint.measureText(" ").toInt()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        paint.color = mPrefixTextColor

        canvas?.drawText(
            mPrefixText,
            super.getCompoundPaddingLeft().toFloat(),
            baseline.toFloat(),
            paint
        )
        super.onDraw(canvas)
    }

    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft() + mPrefixRect.width()
    }
}