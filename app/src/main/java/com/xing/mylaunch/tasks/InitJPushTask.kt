package com.xing.mylaunch.tasks

import cn.jpush.android.api.JPushInterface
import com.xing.launchstarter.task.Task
import com.xing.mylaunch.BaseApp

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class InitJPushTask : Task() {

    override fun dependsOn(): List<Class<out Task>>? {
        val list = arrayListOf<Class<out Task>>()
        list.add(GetDeviceIdTask::class.java)
        return list
    }

    override fun run() {
        JPushInterface.init(mContext)
        val app = mContext as BaseApp
        JPushInterface.setAlias(mContext, 0, app.mDeviceId)
    }
}