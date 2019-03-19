 # Kotlin fetch API PoC
 This project is a PoC of using Kotlin (JS) and the fetch API, it showcases the following features:
 * making GET, POST, PUT, and DELETE requests using the fetch API (available from the Kotlin/JS standard library)
 * Serializing objects to JSON and de-serializing JSON to objects
 
 Note: It is assumed that you have basic knowledge of Kotlin and the fetch API
 
## Installation
 1. Clone this repository

## Running the project
Run the following command in the root directory of the project: `gradlew clean build`. 
This will download gradle, download the required dependencies and compile(transpile) Kotlin to JavaScript 
and put the `index.html` and JS files in a `web` folder in the root directory. 
Open `index.html` in your browser and check the console for the results from the requests. 

## About
The `kotlinx.serialization` library is used for (de)serialization, 
you must annotate serializable classes with the `@Serializable` annotation (see `Todo.kt`).
This will provide the class with a `serializer()` function which must be passed to the `parse` and `stringify` functions.

An extension fetch function has been written for making requests of which you expect a de-serialized result (see `Util.kt`).



 

 
 
 
  
 
 