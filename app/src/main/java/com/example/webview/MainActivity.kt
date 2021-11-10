package com.example.webview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.exit_dialog.*
import java.sql.Connection
import java.util.*

class MainActivity : AppCompatActivity() {

//    var compleLoad = true
//    var redirect = false
//    val TAG = "show Tags"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webViewSetup()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {

        mywebView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                mywebView.setVisibility(View.VISIBLE);
            }
        }
        mywebView.settings.javaScriptEnabled =true
        mywebView.settings.safeBrowsingEnabled = true
        mywebView.loadUrl("https://www.google.com/")
    }

//    mywebView.apply {
//        loadUrl("https://www.google.com/")
//        mywebView.settings.javaScriptEnabled = true
//        mywebView.settings.safeBrowsingEnabled = true
//        mywebView.settings.allowContentAccess = true
//
//    }
    override fun onBackPressed() {
        if (mywebView.canGoBack()) mywebView.goBack() else openDialog()
    }

    fun openDialog() {
        val myDialogView = View.inflate(this, R.layout.exit_dialog, null) //infalte the layout
        val myAlert = AlertDialog.Builder(this)
            .setView(myDialogView).show()
        myAlert.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        myAlert.btnCancal.setOnClickListener(View.OnClickListener {
            myAlert.dismiss()
        })

        myAlert.btnDelete.setOnClickListener(View.OnClickListener {
            finish()
        })


    }

}