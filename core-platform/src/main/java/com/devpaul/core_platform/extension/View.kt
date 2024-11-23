
package com.telefonica.core_platform.extension

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.BaseTarget
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.telefonica.core.R

fun getSpanned(textView: TextView, text: String) {
    val spannableString = SpannableString(text)

    val color = ContextCompat.getColor(textView.context, R.color.blue_light)
    val colorSpan = ForegroundColorSpan(color)
    spannableString.setSpan(colorSpan, text.length - 4, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    val sizeSpan = RelativeSizeSpan(1.15f)
    spannableString.setSpan(sizeSpan, text.length - 4, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    val boldSpan = StyleSpan(Typeface.BOLD)
    spannableString.setSpan(boldSpan, text.length - 4, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    textView.text = spannableString
}
fun TextView.applyStyle(colorRes: Int, typeface: Typeface = Typeface.DEFAULT) {
    setTextColor(ContextCompat.getColor(context, colorRes))
    this.typeface = typeface
}

fun getHighlightedOrderId(orderId: String, context: Context): SpannableString {
    val fullText = "Código: $orderId"
    val spannableString = SpannableString(fullText)
    val highlightColor = ContextCompat.getColor(context, R.color.white)

    if (orderId.length >= 4) {
        val start = fullText.length - 4
        val end = fullText.length
        spannableString.setSpan(
            ForegroundColorSpan(highlightColor),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    return spannableString
}

fun CheckBox.checked() {
    this.isChecked = true
}

fun CheckBox.notChecked() {
    this.isChecked = false
}

fun View.disableInteraction() {
    this.isClickable = false
    this.isFocusable = false
    this.isEnabled = false
}

fun View.enableInteraction() {
    this.isClickable = true
    this.isFocusable = true
    this.isEnabled = true
}

fun View.cancelTransition() {
    transitionName = null
}

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadFromUrl(url: String) =
    Glide.with(this.context.applicationContext)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)

fun ImageView.loadUrlAndPostponeEnterTransition(url: String, activity: FragmentActivity) {
    val target: Target<Drawable> = ImageViewBaseTarget(this, activity)
    Glide.with(context.applicationContext).load(url).into(target)
}

private class ImageViewBaseTarget(var imageView: ImageView?, var activity: FragmentActivity?) :
    BaseTarget<Drawable>() {
    override fun onLoadFailed(errorDrawable: Drawable?) {
        super.onLoadFailed(errorDrawable)
        activity?.supportStartPostponedEnterTransition()
    }

    override fun getSize(cb: SizeReadyCallback) = cb.onSizeReady(SIZE_ORIGINAL, SIZE_ORIGINAL)

    override fun removeCallback(cb: SizeReadyCallback) {
        imageView = null
        activity = null
    }

    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
        imageView?.setImageDrawable(resource)
        activity?.supportStartPostponedEnterTransition()
    }
}