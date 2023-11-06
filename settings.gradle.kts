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
include(":feature-podcasts")
include(":core")
include(":core-networking")
include(":core-caching")
include(":core-ui")
include(":feature-techstack")
include(":feature-about")
