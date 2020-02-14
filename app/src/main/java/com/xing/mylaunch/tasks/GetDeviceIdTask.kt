package com.xing.mylaunch.tasks

import android.provider.Settings
import com.xing.launchstarter.task.Task
import com.xing.mylaunch.BaseApp

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class GetDeviceIdTask : Task() {

    override fun needWait(): Boolean {
        return true
    }

    override fun run() {
        val mDeviceId =
            Settings.System.getString(mContext?.contentResolver, Settings.System.ANDROID_ID)
        val app = mContext as? BaseApp
        app?.mDeviceId = mDeviceId
    }
}