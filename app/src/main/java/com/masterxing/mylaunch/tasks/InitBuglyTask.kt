package com.masterxing.mylaunch.tasks

import android.util.Log
import com.tencent.bugly.crashreport.CrashReport
import com.masterxing.launchstarter.task.Task

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class InitBuglyTask: Task() {
    override fun run() {
        CrashReport.initCrashReport(mContext, "注册时申请的APPID", false)
    }

    override fun getTailRunnable(): Runnable? {
        return Runnable {
            Log.d("task","${this::class.java.simpleName} 结束")
        }
    }
}