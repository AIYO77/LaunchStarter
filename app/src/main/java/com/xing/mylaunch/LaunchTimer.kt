package com.xing.mylaunch

import android.util.Log

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
object LaunchTimer {

    private var sTime: Long = 0

    fun startRecord() {
        sTime = System.currentTimeMillis()
    }

    fun endRecord() {
        endRecord("")
    }

    fun endRecord(msg: String) {
        val cost = System.currentTimeMillis() - sTime
        Log.i("costTime", msg + "cost " + cost)
    }
}