package net.onedaybeard.collectionsby


fun <T, U> Sequence<T>.allBy(selector: (T) -> U, match: U) =
        all(by(selector, match))
fun <T, U> Sequence<T>.allBy(selector: (T) -> U, match: () -> U) =
        all(by(selector, match))

fun <T, U> Sequence<T>.anyBy(selector: (T) -> U, match: U) =
        any(by(selector, match))
fun <T, U> Sequence<T>.anyBy(selector: (T) -> U, match: () -> U) =
        any(by(selector, match))

fun <T, U> Sequence<T>.countBy(selector: (T) -> U, match: U) =
        count(by(selector, match))
fun <T, U> Sequence<T>.countBy(selector: (T) -> U, match: () -> U) =
        count(by(selector, match))

fun <T, U> Sequence<T>.filterBy(selector: (T) -> U, match: () -> U) =
        filter(by(selector, match))
fun <T, U> Sequence<T>.filterBy(selector: (T) -> U, match: U) =
        filter(by(selector, match))

fun <T, U> Sequence<T>.findBy(selector: (T) -> U, match: U) =
        find(by(selector, match))
fun <T, U> Sequence<T>.findBy(selector: (T) -> U, match: () -> U) =
        find(by(selector, match))
        
fun <T, U> Sequence<T>.findLastBy(selector: (T) -> U, match: U) =
        findLast(by(selector, match))
fun <T, U> Sequence<T>.findLastBy(selector: (T) -> U, match: () -> U) =
        findLast(by(selector, match))

fun <T, U> Sequence<T>.firstBy(selector: (T) -> U, match: U) =
        first(by(selector, match))
fun <T, U> Sequence<T>.firstBy(selector: (T) -> U, match: () -> U) =
        first(by(selector, match))

fun <T, U> Sequence<T>.firstOrNullBy(selector: (T) -> U, match: U) =
        firstOrNull(by(selector, match))
fun <T, U> Sequence<T>.firstOrNullBy(selector: (T) -> U, match: () -> U) =
        firstOrNull(by(selector, match))

fun <T, U> Sequence<T>.lastBy(selector: (T) -> U, match: U) =
        last(by(selector, match))
fun <T, U> Sequence<T>.lastBy(selector: (T) -> U, match: () -> U) =
        last(by(selector, match))

fun <T, U> Sequence<T>.noneBy(selector: (T) -> U, match: U) =
        none(by(selector, match))
fun <T, U> Sequence<T>.noneBy(selector: (T) -> U, match: () -> U) =
        none(by(selector, match))

fun <T, U> Sequence<T>.partitionBy(selector: (T) -> U, match: U) =
        partition(by(selector, match))
fun <T, U> Sequence<T>.partitionBy(selector: (T) -> U, match: () -> U) =
        partition(by(selector, match))

fun <T, U> Sequence<T>.singleBy(selector: (T) -> U, match: U) =
        single(by(selector, match))
fun <T, U> Sequence<T>.singleBy(selector: (T) -> U, match: () -> U) =
        single(by(selector, match))
        
fun <T, U> Sequence<T>.singleOrNullBy(selector: (T) -> U, match: U) =
        singleOrNull(by(selector, match))
fun <T, U> Sequence<T>.singleOrNullBy(selector: (T) -> U, match: () -> U) =
        singleOrNull(by(selector, match))

