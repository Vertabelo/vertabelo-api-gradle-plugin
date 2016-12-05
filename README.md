# vertabelo-download-gradle-plugin
A gradle plugin to download xml and sql from Vertabelo

## How to

Add it to your buildscript dependencies:


```groovy
buildscript {

    repositories {
        mavenCentral()
    }

    dependencies {
        // ...
        // FIXME
    }
}

vertabelo {
    destSQLFile = 'FIXME'
    destXMLFile = 'FIXME'
}

```

Apply it:

```groovy
apply plugin: FIXME
```
