package com.gmail.apigeoneer.motionlayoutdemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({ 
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, LoginActivity::class.java)
            this.startActivity(mainIntent)

            //overriding the default sliding animation transition to the new activity

            // remove the Splash Activity from the stack (since we only want to show it once i.e., at the v beginning)
            this.finish()
        }, 1000)
    }
}