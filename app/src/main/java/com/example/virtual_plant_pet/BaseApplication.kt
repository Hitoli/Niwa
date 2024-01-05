package com.example.virtual_plant_pet

import android.app.Application
import com.example.virtual_plant_pet.Di.DIModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(DIModule)
        }
    }
}