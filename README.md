# collections-by - extensions for Sequence and Iterable 

Provides overloaded functions - for `Iterable`, `Sequenece`, `List`
and `Array` - taking a predicate. Overloaded functions take an additional
`selector` parameter, in addition to predicate or object to match.
E.g.`findBy`, `removeAllBy`.

Two overloads are generated for each function and underlying collection:
- with selector and object-to-equal
- with selector and predicate

```kotlin
// same set of overloads are also generated for Sequence, Array etc
fun <T, U> List<T>.findBy(selector: (T) -> U, predicate: (U) -> Boolean): List<T>
fun <T, U> List<T>.findBy(selector: (T) -> U, match: U): List<T>

// usage
people.findBy(Person::surname, "Papari")
people.findBy(Person::surname) { name -> name == "Papari" }
```

## Usage

Current `$VERSION` is `0.1.0-SNAPSHOT`

### Maven

```xml
<dependency>
    <groupId>net.onedaybeard.collections-by</groupId>
    <artifactId>core</artifactId>
    <version>${VERSION}</version>
</dependency>
```

### Gradle

```groovy
implementation "net.onedaybeard.collections-by:core:${VERSION}"
```

### Direct download

`$ java -ea -javaagent:agent-${VERSION}.jar` ...

 - [Snapshot](https://oss.sonatype.org/content/repositories/snapshots/net/onedaybeard/collections-by/) 
 - [Release](http://repo1.maven.org/maven2/net/onedaybeard/collections-by/) 
