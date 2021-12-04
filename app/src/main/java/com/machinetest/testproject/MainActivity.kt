package com.machinetest.testproject

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private var progressDialog: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController: NavController =
            Navigation.findNavController(this, R.id.nav_host_fragment)
        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    fun showProgress() {
        if (isFinishing) return
        try {
            if (progressDialog != null) progressDialog?.dismiss()
            val builder = AlertDialog.Builder(this)
            val li = LayoutInflater.from(baseContext)
            val promptsView: View = li.inflate(R.layout.my_progress, null)
            builder.setView(promptsView)
            progressDialog = builder.create()
            progressDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            progressDialog?.setCanceledOnTouchOutside(false)
            progressDialog?.setCancelable(false)
            progressDialog?.show()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun hideProgress() {
        if (isFinishing) return
        try {
            if (progressDialog != null) {
                if (progressDialog?.isShowing == true) progressDialog?.dismiss()
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}