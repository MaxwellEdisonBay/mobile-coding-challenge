pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Podcast App"
include(":app")
include(":feature-dashboard")
include(":feature-details")
include(":core")
include(":core-networking")
include(":core-caching")
include(":core-ui")
