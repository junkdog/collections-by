package net.onedaybeard.collectionsby


fun <T, U> Iterable<T>.allBy(selector: (T) -> U, match: U) =
        all(by(selector, match))
fun <T, U> Iterable<T>.allBy(selector: (T) -> U, match: () -> U) =
        all(by(selector, match))

fun <T, U> Iterable<T>.anyBy(selector: (T) -> U, match: U) =
        any(by(selector, match))
fun <T, U> Iterable<T>.anyBy(selector: (T) -> U, match: () -> U) =
        any(by(selector, match))
fun <T, U> Iterable<T>.anyBy2(selector: (T) -> U, match: U) =
        any(by(selector, match))

fun <T, U> Iterable<T>.countBy(selector: (T) -> U, match: U) =
        count(by(selector, match))
fun <T, U> Iterable<T>.countBy(selector: (T) -> U, match: () -> U) =
        count(by(selector, match))

fun <T, U> Iterable<T>.filterBy(selector: (T) -> U, match: () -> U) =
        filter(by(selector, match))
fun <T, U> Iterable<T>.filterBy(selector: (T) -> U, match: U) =
        filter(by(selector, match))

fun <T, U> Iterable<T>.findBy(selector: (T) -> U, match: U) =
        find(by(selector, match))
fun <T, U> Iterable<T>.findBy(selector: (T) -> U, match: () -> U) =
        find(by(selector, match))
        
fun <T, U> Iterable<T>.findLastBy(selector: (T) -> U, match: U) =
        findLast(by(selector, match))
fun <T, U> Iterable<T>.findLastBy(selector: (T) -> U, match: () -> U) =
        findLast(by(selector, match))

fun <T, U> Iterable<T>.firstBy(selector: (T) -> U, match: U) =
        first(by(selector, match))
fun <T, U> Iterable<T>.firstBy(selector: (T) -> U, match: () -> U) =
        first(by(selector, match))

fun <T, U> Iterable<T>.firstOrNullBy(selector: (T) -> U, match: U) =
        firstOrNull(by(selector, match))
fun <T, U> Iterable<T>.firstOrNullBy(selector: (T) -> U, match: () -> U) =
        firstOrNull(by(selector, match))

fun <T, U> Iterable<T>.lastBy(selector: (T) -> U, match: U) =
        last(by(selector, match))
fun <T, U> Iterable<T>.lastBy(selector: (T) -> U, match: () -> U) =
        last(by(selector, match))

fun <T, U> Iterable<T>.noneBy(selector: (T) -> U, match: U) =
        none(by(selector, match))
fun <T, U> Iterable<T>.noneBy(selector: (T) -> U, match: () -> U) =
        none(by(selector, match))

fun <T, U> Iterable<T>.partitionBy(selector: (T) -> U, match: U) =
        partition(by(selector, match))
fun <T, U> Iterable<T>.partitionBy(selector: (T) -> U, match: () -> U) =
        partition(by(selector, match))

fun <T, U> Iterable<T>.singleBy(selector: (T) -> U, match: U) =
        single(by(selector, match))
fun <T, U> Iterable<T>.singleBy(selector: (T) -> U, match: () -> U) =
        single(by(selector, match))
        
fun <T, U> Iterable<T>.singleOrNullBy(selector: (T) -> U, match: U) =
        singleOrNull(by(selector, match))
fun <T, U> Iterable<T>.singleOrNullBy(selector: (T) -> U, match: () -> U) =
        singleOrNull(by(selector, match))

