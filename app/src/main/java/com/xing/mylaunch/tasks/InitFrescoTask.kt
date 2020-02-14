package com.xing.mylaunch.tasks

import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.listener.RequestListener
import com.xing.launchstarter.task.Task
import com.xing.mylaunch.callback.FrescoTraceListener

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class InitFrescoTask:Task() {

    override fun run() {
        val listenerset = hashSetOf<RequestListener>()
        listenerset.add(FrescoTraceListener())
        val config =
            ImagePipelineConfig.newBuilder(mContext).setRequestListeners(listenerset)
                .build()
        Fresco.initialize(mContext, config)
    }
}