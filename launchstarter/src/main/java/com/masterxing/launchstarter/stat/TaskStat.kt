package com.masterxing.launchstarter.stat

import com.masterxing.launchstarter.utils.DispatcherLog
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
object TaskStat {
    @Volatile
    private var sCurrentSituation = ""
    private val sBeans = arrayListOf<TaskStatBean>()
    private var sTaskDoneCount = AtomicInteger()
    private const val sOpenLaunchStat = false // 是否开启统计

    fun getCurrentSituation(): String? {
        return sCurrentSituation
    }

    fun setCurrentSituation(currentSituation: String) {
        if (!sOpenLaunchStat) {
            return
        }
        DispatcherLog.i("currentSituation   $currentSituation")
        sCurrentSituation = currentSituation
        setLaunchStat()
    }

    fun markTaskDone() {
        sTaskDoneCount.getAndIncrement()
    }

    fun setLaunchStat() {
        sBeans.add(TaskStatBean(sCurrentSituation, sTaskDoneCount.get()))
        sTaskDoneCount = AtomicInteger(0)
    }
}