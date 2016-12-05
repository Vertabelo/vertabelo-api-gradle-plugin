# vertabelo-api-gradle-plugin
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
        classpath group:'com.vertabelo.gradle', name:'vertabelo', version:'1.0.1'
    }
}

vertabelo {
    destSQLFile = 'destination/model.sql'
    destXMLFile = 'destination/model.xml'
    apiToken = System.getenv('VERTABELO_API_TOKEN')
    modelId = 'model gid'
    modalTag = 'model tag (optional)'
}
```

Parameters description:

1. destSQLFILE - destination where sql file will be written
2. destXMLFile - destination where xml file will be written
3. apiToken - API token generated in Vertabelo, more here: http://www.vertabelo.com/blog/documentation/vertabelo-api
4. modelId = model's gid, more here: http://www.vertabelo.com/blog/documentation/vertabelo-api
5. modelTag = model's tag, more here: http://www.vertabelo.com/blog/documentation/vertabelo-api

and apply it:

```groovy
apply plugin: vertabelo
```
