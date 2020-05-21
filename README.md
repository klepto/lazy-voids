# lazy-voids
[![Maven Central](https://img.shields.io/maven-central/v/dev.klepto.lazyvoids/lazyvoids.svg?color=blue)](https://search.maven.org/search?q=g:dev.klepto.lazyvoids) [![Gradle CI](https://github.com/klepto/lazy-voids/workflows/ci/badge.svg)](https://github.com/klepto/lazy-voids/actions?query=workflow%3Aci) [![License: Unlicense](https://img.shields.io/badge/License-Unlicense-green.svg?color=ff69b4)](https://github.com/klepto/lazy-voids/blob/master/LICENSE)

Various utilities to be used as static imports in pseudocode and other non-serious applications.
This repository acts as a database for Java tricks & general purpose helpful methods that can be imported statically.


<b>Disclaimer:</b> Do not use this in production applications.<br>
<sub>(unless you are god c0dar who uses epic bools & voids on regular basis)</sub>

# Installation
```gradle
repositories {
    mavenCentral()
}

dependencies {
    implementation "dev.klepto.lazyvoids:lazyvoids:0.0.1"
}
```

# Features

Library contains both useful and not-so useful utilities. Since amount of utilities is going to expand over time,
the list of features is unlikely to be updated. For more information, browse this repository.

<b>Warning:</b> Legendary voids
## when()
```java
String number = "one";
int value = when(number)
        .map("one", 1)
        .map("two", 2)
        .orElse(0); // returns 1
```

## runtimeThrows()
```java
 List<URL> fileUrls = Files.walk(directory)
        .map(path -> runtimeThrows(() -> path.toUri().toURL()))
        .collect(Collectors.toList());
```

## enumEntryMap()
```java
public enum Item {
    SIX_CONSOLES(1337),
    GAMER_GUITAR(9001),
    DOG_CAM(420);

    @Getter private final int uid;

    Item(int uid) {
        this.uid = uid;
    }
}
```
```java
Map<Integer, Item> uidToItem = enumEntryMap(Item::getUid);
```

# Contributing
Happy voiding lads. If you have any nuclear ints make sure to create a pull request.

# License
Nobody reads this bit.
