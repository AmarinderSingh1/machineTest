package com.machinetest.testproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class CommonViewModel(application: Application): AndroidViewModel(application) {
    var context = application
}