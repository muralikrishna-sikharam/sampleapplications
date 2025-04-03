pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://mvnrepository.com/artifact/com.wang.avi/library")
        maven("https://repo.spring.io/ui/native/plugins-release")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
      //  maven("https://mvnrepository.com/artifact/com.github.tbruyelle/rxpermissions")
        maven("https://mvnrepository.com/artifact/")
    }
}

rootProject.name = "MarghApplication"
include(":app")
 