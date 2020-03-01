# LaunchStarter

[![Release Version](https://img.shields.io/github/release/masterxing/LaunchStarter.svg?maxAge=2592000?style=flat-square)](https://github.com/masterxing/LaunchStarter/releases)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/masterxing/LaunchStarter/pulls)
[![Platform Support](https://img.shields.io/badge/Platform-Android%20-brightgreen.svg)](https://github.com/masterxing/LaunchStarter/wiki)

LaunchStarter是充分利用CPU多核，自动梳理任务顺序，提升APP的50%启动速度。

# Getting started

## Installation

在项目的`build.gradle`文件中添加：

```groovy
compile 'com.github.masterxing:LaunchStarter:{release}'
```

## Usage

在Application中调用：

```java
 TaskDispatcher.init(this)
 TaskDispatcher.createInstance().apply {
            addTask(ATask())
            addTask(BTask())
		...
            start()
            //有需要等待完成结束的任务
            await()
        }
```

新建子线程任务，继承Task()

```java
class ATask : Task() {
    override fun run() {
       ...
    }
}
```

新建主线程任务，继承MainTask()

```java
class BTask : MainTask() {
    override fun run() {
       ...
    }
}
```

场景1: 线程B依赖于A，必须等待A执行结束

```java
class BTask : MainTask() {
  override fun dependsOn(): List<Class<out Task>>? {
        val listOf = arrayListOf<Class<out Task>>()
        listOf.add(ATask::class.java)
        return listOf
    }
    override fun run() {
       ...
    }
}
```
场景2: 必须执行结束的任务 主线程等待结果

```java
class ATask : MainTask() {
    override fun needWait(): Boolean {
        return true
    }
    override fun run() {
       ...
    }
}
```
**更多使用场景，请查看Demo**
