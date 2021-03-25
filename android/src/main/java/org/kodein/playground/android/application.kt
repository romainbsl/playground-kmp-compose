package org.kodein.playground.android

import android.app.Application
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.androidCoreModule
import org.kodein.playground.common.commonDI

class KodeinApplication : Application(), DIAware {
    override val di by DI.lazy {
        import(androidCoreModule(this@KodeinApplication))
        import(commonDI)
    }
}