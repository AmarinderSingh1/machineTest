package com.machinetest.testproject

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.machinetest.testproject.utility.Utility

object BindingAdapters {

    @BindingAdapter("imageUrl")
    @JvmStatic fun loadImage(view: ImageView, url: String) {
        Log.e("Print "," "+url)
        Utility.loadImageFromGlide(view.context,url,view)
    }

    /**
     * A Binding Adapter that is called whenever the value of the attribute `android:progressTint`
     * changes. Depending on the value it determines the color of the progress bar.
     */

    /**
     *  Sets the value of the progress bar so that 5 likes will fill it up.
     *
     *  Showcases Binding Adapters with multiple attributes. Note that this adapter is called
     *  whenever any of the attribute changes.
     */


    /**
     * Unused Binding Adapter to replace the Binding Converter that hides a view if the number
     * of likes is zero.
     */

}