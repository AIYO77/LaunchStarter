package com.xing.launchstarter.task

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
abstract class MainTask : Task() {

    override fun runOnMainThread(): Boolean {
        return true
    }
}