package com.tmm.inactiveorsessiontimeout

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(),SessionTimeOutListioner {
    override fun onSessionTimeOut() {
        runOnUiThread {
            AlertDialog.Builder(this)
                .setMessage("Session Timeout.")
                .setCancelable(false)
                .setPositiveButton("Ok"){
                    dialog,_->
                    dialog.dismiss()
                    finish()
                }
                .show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).registerSessionTimeOutListener(this)
        (application as App).startSession()
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        (application as App).onUserInteraction()
    }
}
