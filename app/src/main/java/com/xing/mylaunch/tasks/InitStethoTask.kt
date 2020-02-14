package com.xing.mylaunch.tasks

import com.facebook.stetho.Stetho
import com.xing.launchstarter.task.MainTask

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc: 主线程 执行的task
 */
class InitStethoTask : MainTask() {

    override fun run() {
        Stetho.initializeWithDefaults(mContext)
    }
}