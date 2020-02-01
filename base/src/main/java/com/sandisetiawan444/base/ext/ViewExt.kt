package com.sandisetiawan444.base.ext

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.widget.ImageView
import com.sandisetiawan444.base.util.GlideApp

/**
 * Created by Sandi on 31/01/2020.
 */

fun View.show() {
    val shortAnimationDuration =
        context?.resources?.getInteger(android.R.integer.config_shortAnimTime) ?: 0

    // Set the content view to 0% opacity but visible, so that it is visible
    // (but fully transparent) during the animation.
    alpha = 0f
    visibility = View.VISIBLE

    // Animate the content view to 100% opacity, and clear any animation
    // listener set on the view.
    animate()
        .alpha(1f)
        .setDuration(shortAnimationDuration.toLong())
        .setListener(null)
}

fun View.hide() {
    val shortAnimationDuration =
        context?.resources?.getInteger(android.R.integer.config_shortAnimTime) ?: 0

    // Animate the showProgress view to 0% opacity. After the animation ends,
    // set its visibility to GONE as an optimization step (it won't
    // participate in layout passes, etc.)
    animate()
        ?.alpha(0f)
        ?.setDuration(shortAnimationDuration.toLong())
        ?.setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                visibility = View.GONE
            }
        })
}

fun ImageView.loadImage(imageUrl: String?) {
    GlideApp.with(this.context).load(imageUrl).into(this)
}