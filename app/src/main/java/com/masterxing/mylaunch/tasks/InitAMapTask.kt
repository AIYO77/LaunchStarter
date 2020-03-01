package com.masterxing.mylaunch.tasks

import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.masterxing.launchstarter.task.Task

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class InitAMapTask : Task() {
    private val mLocationListener = AMapLocationListener {
        // 一些处理
    }

    override fun run() {
        val mLocationClient = AMapLocationClient(mContext)
        mLocationClient.setLocationListener(mLocationListener)
        val mLocationOption = AMapLocationClientOption()
        mLocationOption.locationMode = AMapLocationClientOption.AMapLocationMode.Battery_Saving
        mLocationOption.isOnceLocation = true
        mLocationClient.setLocationOption(mLocationOption)
        mLocationClient.startLocation()
    }
}