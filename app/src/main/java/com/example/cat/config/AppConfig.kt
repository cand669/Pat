package com.example.cat.config

import com.drake.serialize.serialize.annotation.SerializeConfig
import com.drake.serialize.serialize.serial

@SerializeConfig(mmapID = "app_config")
object AppConfig {
    var lug: String by serial("eng")
}