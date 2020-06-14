package net.onedaybeard.collectionsby


fun <T, U> MutableIterable<T>.removeAllBy(selector: (T) -> U, match: U) =
        removeAll(by(selector, match))
fun <T, U> MutableIterable<T>.removeAllBy(selector: (T) -> U, match: () -> U) =
        removeAll(by(selector, match))

fun <T, U> MutableIterable<T>.removeBy(selector: (T) -> U, match: U) =
        removeAll(by(selector, match))