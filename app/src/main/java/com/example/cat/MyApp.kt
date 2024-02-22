package com.example.cat

import android.app.Application

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        val isNet: Boolean = false
        val glist: Map<String, String> = mapOf(
            "eng" to "英语",
            "rus" to "俄语",
            "spa" to "西班牙语",
            "deu" to "德语",
            "jpn" to "日语"
        )
    }
}