package com.masterxing.launchstarter.utils

import android.util.Log

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
object DispatcherLog {
    private var sDebug = true

    fun i(msg: String) {
        if (!sDebug) {
            return
        }
        Log.i("task", msg)
    }

    fun isDebug(): Boolean {
        return sDebug
    }

    fun setDebug(debug: Boolean) {
        sDebug = debug
    }
}