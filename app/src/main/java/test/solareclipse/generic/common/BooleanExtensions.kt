package test.solareclipse.generic.common

internal inline fun <R> Boolean.then(onTrue: () -> R) = then(onTrue, { null })

internal inline fun <R> Boolean.then(onTrue: () -> R, onFalse: () -> R) =
        if (this) onTrue() else onFalse()