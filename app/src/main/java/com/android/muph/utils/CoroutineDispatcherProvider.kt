package com.android.muph.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class CoroutineDispatcherProvider {

    companion object {
        var delegate: (() -> CoroutineContext?) = { null }
    }

    open val Main: CoroutineContext by lazy { Dispatchers.Main }

    open val IO: CoroutineContext by lazy { Dispatchers.IO }

    open val Default: CoroutineContext by lazy { Dispatchers.Default }
}

val CoroutineScope.provider: CoroutineDispatcherProvider
    get() = CoroutineDispatcherProvider()

class CoroutineProviderScope : CoroutineScope {
    override val coroutineContext: CoroutineContext = SupervisorJob() + provider.Main
}
