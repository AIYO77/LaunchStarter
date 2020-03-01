package com.masterxing.mylaunch.tasks

import com.facebook.stetho.Stetho
import com.masterxing.launchstarter.task.MainTask

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc: 主线程 执行的task
 */
class InitStethoTask : MainTask() {

    override fun needWait(): Boolean {
        return super.needWait()
    }
    override fun run() {
        Stetho.initializeWithDefaults(mContext)
    }
}