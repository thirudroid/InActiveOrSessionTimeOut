package com.tmm.inactiveorsessiontimeout

import android.app.Application
import java.util.*

class App : Application() {
    private var listener: SessionTimeOutListioner? = null
    private var timer:Timer? = null
    override fun onCreate() {
        super.onCreate()
    }

    fun startSession(){
        cancelTimer()
        timer = Timer()
        timer?.schedule(object:TimerTask(){
            override fun run() {
                listener?.onSessionTimeOut()
            }
        },10000)
    }

    private fun cancelTimer() {
        timer?.cancel()
   }

    fun registerSessionTimeOutListener(listener:SessionTimeOutListioner){
        this.listener = listener
    }

    fun onUserInteraction() {
        startSession()
    }
}