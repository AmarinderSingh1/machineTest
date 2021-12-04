package com.machinetest.testproject.utility

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.*
import android.view.*
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.machinetest.testproject.R
import java.util.*


class Utility {

    companion object {
        fun showToast(
            context: Context?,
            message: String?
        ) {
            if (message != null && context != null) {
                val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }

        @SuppressLint("CheckResult")
        fun loadImageFromGlide(
            context: Context,
            imageURL: String,
            imageView: ImageView
        ) {
            Glide.with(context).load(imageURL)
                .error(R.drawable.ic_launcher_background)
                .into(imageView)

        }

    }
}