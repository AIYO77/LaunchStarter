package com.xing.launchstarter

import android.os.Looper
import android.os.MessageQueue.IdleHandler
import com.xing.launchstarter.task.DispatchRunnable
import com.xing.launchstarter.task.Task
import java.util.*

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc: 延迟初始化
 */
class DelayInitDispatcher {
    private val mDelayTasks = LinkedList<Task>()

    private val mIdleHandler = IdleHandler {
        if (mDelayTasks.size > 0) {
            val task = mDelayTasks.poll()
            DispatchRunnable(task).run()
        }
        !mDelayTasks.isEmpty()
    }

    fun addTask(task: Task): DelayInitDispatcher? {
        mDelayTasks.add(task)
        return this
    }

    fun start() {
        Looper.myQueue().addIdleHandler(mIdleHandler)
    }
}