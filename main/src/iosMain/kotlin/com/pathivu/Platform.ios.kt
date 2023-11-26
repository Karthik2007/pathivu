package com.pathivu

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() +
            " " + UIDevice.currentDevice.systemVersion +
            "/n" + UIDevice.currentDevice.batteryLevel
}

actual fun getPlatform(): Platform = IOSPlatform()