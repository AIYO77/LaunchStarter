package com.masterxing.mylaunch.callback

import com.facebook.imagepipeline.listener.RequestListener
import com.facebook.imagepipeline.request.ImageRequest

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class FrescoTraceListener: RequestListener {
    override fun onUltimateProducerReached(
        requestId: String?,
        producerName: String?,
        successful: Boolean
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestStart(
        request: ImageRequest?,
        callerContext: Any?,
        requestId: String?,
        isPrefetch: Boolean
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProducerFinishWithCancellation(
        requestId: String?,
        producerName: String?,
        extraMap: MutableMap<String, String>?
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestFailure(
        request: ImageRequest?,
        requestId: String?,
        throwable: Throwable?,
        isPrefetch: Boolean
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestCancellation(requestId: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestSuccess(request: ImageRequest?, requestId: String?, isPrefetch: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requiresExtraMap(requestId: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProducerEvent(requestId: String?, producerName: String?, eventName: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProducerFinishWithFailure(
        requestId: String?,
        producerName: String?,
        t: Throwable?,
        extraMap: MutableMap<String, String>?
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProducerStart(requestId: String?, producerName: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProducerFinishWithSuccess(
        requestId: String?,
        producerName: String?,
        extraMap: MutableMap<String, String>?
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}