package com.example.eulerity

import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.eulerity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_Eulerity)  // setting the Theme to Base Theme after Main Activity is loaded
        setContentView(binding.root)
            checkInternet()
            setUpWebView()                      // Calling function to setup the webView
    }

    private fun checkInternet(){
        val conMgr = applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        if (netInfo == null || !netInfo.isConnected || !netInfo.isAvailable)
            Toast.makeText(this, "No Internet connection!", Toast.LENGTH_LONG).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setUpWebView() {
        binding.webView.webViewClient= WebViewClient()

        binding.webView.apply{
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            loadUrl("https://www.eulerity.com/")  // loading the website url
        }
    }
}