package net.onedaybeard.collectionsby

fun <T, U> by(
        selector: (T) -> U,
        match: () -> U
): (T) -> Boolean = { instance -> match() == selector(instance)  }

fun <T, U> by(
        selector: (T) -> U,
        match: U
): (T) -> Boolean = { instance -> match == selector(instance) }

fun <T, U> by(
        selector: (T) -> U,
        predicate: (U) -> Boolean
): (T) -> Boolean = { instance -> predicate(selector(instance)) }

