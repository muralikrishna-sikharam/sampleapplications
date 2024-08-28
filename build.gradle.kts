buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
        classpath("io.realm:realm-gradle-plugin:10.10.0") // Replace with the latest version number
    }
}
true
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("io.realm.kotlin") version "1.16.0" apply false
}
// Needed to make the Suppress annotation work for the plugins block