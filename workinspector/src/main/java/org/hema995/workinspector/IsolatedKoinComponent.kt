package org.hema995.workinspector

import org.koin.core.Koin
import org.koin.core.component.KoinComponent

internal interface IsolatedKoinComponent : KoinComponent {

    override fun getKoin(): Koin = WorkInspectorInitProvider.koin
}