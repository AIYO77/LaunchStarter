package com.masterxing.mylaunch

import android.app.Application
import android.provider.Settings
import cn.jpush.android.api.JPushInterface
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.Stetho
import com.tencent.bugly.crashreport.CrashReport
import com.masterxing.launchstarter.LaunchStarter
import com.masterxing.mylaunch.tasks.*

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class BaseApp : Application() {

    var mDeviceId: String? = null

    private var mLocationClient: AMapLocationClient? = null
    private var mLocationOption: AMapLocationClientOption? = null

    override fun onCreate() {
        super.onCreate()

        LaunchTimer.startRecord()

//        initDeviceId()
//        initAMap()
//        initBugly()
//        initFresco()
//        initJPush()
//        initStetho()

        LaunchStarter.init(this)

        val launchStarter = LaunchStarter.createInstance()
        launchStarter
            .addTask(InitAMapTask())
            .addTask(GetDeviceIdTask())
            .addTask(InitBuglyTask())
            .addTask(InitFrescoTask())
            .addTask(InitJPushTask())
            .addTask(InitStethoTask())
            .start()
        // 有必须初始化完成的任务 调用
        launchStarter.await()

        LaunchTimer.endRecord()
    }

    private fun initDeviceId() {
        mDeviceId =
            Settings.System.getString(this.contentResolver, Settings.System.ANDROID_ID)
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }

    private fun initJPush() {
        JPushInterface.init(this)
        JPushInterface.setAlias(this, 0, mDeviceId)
    }

    private fun initFresco() {
        Fresco.initialize(this)
    }

    private val mLocationListener = AMapLocationListener {}

    private fun initAMap() {
        mLocationOption = AMapLocationClientOption().apply {
            locationMode = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy
            isOnceLocation = true

        }
        mLocationClient = AMapLocationClient(applicationContext).apply {
            setLocationListener(mLocationListener)
            setLocationOption(mLocationOption)
            startLocation()
        }
    }


    private fun initBugly() {
        CrashReport.initCrashReport(applicationContext, "注册时申请的APPID", false)
    }


}