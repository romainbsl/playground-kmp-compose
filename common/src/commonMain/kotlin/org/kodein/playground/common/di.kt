package org.kodein.playground.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import org.kodein.di.*

val LocalDI = compositionLocalOf<DI> { error("Missing DI container!") }

@Composable
public fun di(): DI = LocalDI.current

@Composable
public inline fun <reified T : Any> instance(tag: Any? = null): T = LocalDI.current.direct.instance(tag)

@Composable
public inline fun <reified A : Any, reified T : Any> instance(tag: Any? = null, arg: A): T = LocalDI.current.direct.instance(tag, arg)

@Composable
public fun withDI(builder: (DI.MainBuilder.() -> Unit), content: @Composable () -> Unit): Unit =
    CompositionLocalProvider(LocalDI provides DI { builder() }) { content() }

@Composable
public fun withDI(di: DI, content: @Composable () -> Unit): Unit =
    CompositionLocalProvider(LocalDI provides di) { content() }

@Composable
public fun subDI(
    sub: DI.MainBuilder.() -> Unit,
    allowSilentOverride: Boolean = false,
    copy: Copy = Copy.NonCached,
    content: @Composable() () -> Unit
) {
    val di = subDI(parentDI = LocalDI.current, allowSilentOverride, copy) { sub() }
    CompositionLocalProvider(LocalDI provides di) { content() }
}

