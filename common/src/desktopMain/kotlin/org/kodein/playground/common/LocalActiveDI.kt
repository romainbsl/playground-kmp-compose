package org.kodein.playground.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import org.kodein.di.DI

//actual fun LocalActiveDI(): ProvidableCompositionLocal<DI> = staticCompositionLocalOf {
//    DI {
//
//    }
//}
//@Composable
//actual fun DI.Builder.getLocalDI(): () -> Unit = {
//
//}
//actual fun applyLocalDI(content: @Composable () -> Unit) {
//
//}