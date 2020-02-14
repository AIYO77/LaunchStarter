package com.xing.launchstarter.task

import android.os.Looper
import android.os.Process
import androidx.core.os.TraceCompat
import com.xing.launchstarter.TaskDispatcher
import com.xing.launchstarter.stat.TaskStat
import com.xing.launchstarter.utils.DispatcherLog

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class DispatchRunnable(
    private val mTask: Task?,
    private val mTaskDispatcher: TaskDispatcher? = null
) : Runnable {

    override fun run() {
        if (mTask == null) return
        TraceCompat.beginSection(mTask.javaClass.simpleName)
        DispatcherLog.i(
            "${mTask.javaClass.simpleName} begin run  Situation  ${TaskStat.getCurrentSituation()}"
        )
        Process.setThreadPriority(mTask.priority())
        var startTime = System.currentTimeMillis()

        mTask.setWaiting(true)
        mTask.waitToSatisfy()

        val waitTime = System.currentTimeMillis() - startTime
        startTime = System.currentTimeMillis()

        // 执行Task
        mTask.setRunning(true)
        mTask.run()

        // 执行Task的尾部任务
        val tailRunnable = mTask.getTailRunnable()
        tailRunnable?.run()

        if (!mTask.needCall() || !mTask.runOnMainThread()) {
            printTaskLog(startTime, waitTime)
            TaskStat.markTaskDone()
            mTask.setFinished(true)
            if (mTaskDispatcher != null) {
                mTaskDispatcher.satisfyChildren(mTask)
                mTaskDispatcher.markTaskDone(mTask)
            }
            DispatcherLog.i("${mTask.javaClass.simpleName} finish")
        }
        TraceCompat.endSection()
    }

    /**
     * 打印出来Task执行的日志
     *
     * @param startTime
     * @param waitTime
     */
    private fun printTaskLog(startTime: Long, waitTime: Long) {
        if (mTask == null) return
        val runTime = System.currentTimeMillis() - startTime
        if (DispatcherLog.isDebug()) {
            DispatcherLog.i(
                mTask.javaClass.simpleName + "  wait " + waitTime + "    run "
                        + runTime + "   isMain " + (Looper.getMainLooper() == Looper.myLooper())
                        + "  needWait " + (mTask.needWait() || Looper.getMainLooper() == Looper.myLooper())
                        + "  ThreadId " + Thread.currentThread().id
                        + "  ThreadName " + Thread.currentThread().name
                        + "  Situation  " + TaskStat.getCurrentSituation()
            )
        }
    }
}