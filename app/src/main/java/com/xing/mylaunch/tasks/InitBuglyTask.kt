package com.xing.mylaunch.tasks

import com.tencent.bugly.crashreport.CrashReport
import com.xing.launchstarter.task.Task

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
}