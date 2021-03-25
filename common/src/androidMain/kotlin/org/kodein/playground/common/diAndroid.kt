package org.kodein.playground.common

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import org.kodein.di.DI
import org.kodein.di.android.di

@Composable
fun getLocalDI(): DI {
    val di by di(LocalContext.current) ; return di
}

@Composable
fun withDI(app: @Composable () -> Unit) = CompositionLocalProvider(LocalDI provides getLocalDI()) { app() }
