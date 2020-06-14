package net.onedaybeard.collectionsby


fun <T, U> Array<out T>.allBy(selector: (T) -> U, match: U) =
        all(by(selector, match))
fun <T, U> Array<out T>.allBy(selector: (T) -> U, match: () -> U) =
        all(by(selector, match))

fun <T, U> Array<out T>.anyBy(selector: (T) -> U, match: U) =
        any(by(selector, match))
fun <T, U> Array<out T>.anyBy(selector: (T) -> U, match: () -> U) =
        any(by(selector, match))
fun <T, U> Array<out T>.anyBy2(selector: (T) -> U, match: U) =
        any(by(selector, match))

fun <T, U> Array<out T>.countBy(selector: (T) -> U, match: U) =
        count(by(selector, match))
fun <T, U> Array<out T>.countBy(selector: (T) -> U, match: () -> U) =
        count(by(selector, match))

fun <T, U> Array<out T>.filterBy(selector: (T) -> U, match: () -> U) =
        filter(by(selector, match))
fun <T, U> Array<out T>.filterBy(selector: (T) -> U, match: U) =
        filter(by(selector, match))

fun <T, U> Array<out T>.findBy(selector: (T) -> U, match: U) =
        find(by(selector, match))
fun <T, U> Array<out T>.findBy(selector: (T) -> U, match: () -> U) =
        find(by(selector, match))
        
fun <T, U> Array<out T>.findLastBy(selector: (T) -> U, match: U) =
        findLast(by(selector, match))
fun <T, U> Array<out T>.findLastBy(selector: (T) -> U, match: () -> U) =
        findLast(by(selector, match))

fun <T, U> Array<out T>.firstBy(selector: (T) -> U, match: U) =
        first(by(selector, match))
fun <T, U> Array<out T>.firstBy(selector: (T) -> U, match: () -> U) =
        first(by(selector, match))

fun <T, U> Array<out T>.firstOrNullBy(selector: (T) -> U, match: U) =
        firstOrNull(by(selector, match))
fun <T, U> Array<out T>.firstOrNullBy(selector: (T) -> U, match: () -> U) =
        firstOrNull(by(selector, match))

fun <T, U> Array<out T>.lastBy(selector: (T) -> U, match: U) =
        last(by(selector, match))
fun <T, U> Array<out T>.lastBy(selector: (T) -> U, match: () -> U) =
        last(by(selector, match))

fun <T, U> Array<out T>.noneBy(selector: (T) -> U, match: U) =
        none(by(selector, match))
fun <T, U> Array<out T>.noneBy(selector: (T) -> U, match: () -> U) =
        none(by(selector, match))

fun <T, U> Array<out T>.partitionBy(selector: (T) -> U, match: U) =
        partition(by(selector, match))
fun <T, U> Array<out T>.partitionBy(selector: (T) -> U, match: () -> U) =
        partition(by(selector, match))

fun <T, U> Array<out T>.singleBy(selector: (T) -> U, match: U) =
        single(by(selector, match))
fun <T, U> Array<out T>.singleBy(selector: (T) -> U, match: () -> U) =
        single(by(selector, match))
        
fun <T, U> Array<out T>.singleOrNullBy(selector: (T) -> U, match: U) =
        singleOrNull(by(selector, match))
fun <T, U> Array<out T>.singleOrNullBy(selector: (T) -> U, match: () -> U) =
        singleOrNull(by(selector, match))

