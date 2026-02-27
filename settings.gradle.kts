pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android-Basics-Kotlin-Compose-2026"
include(":app")
include(":app:greeting_card")
include(":app:happy_birthday")
include(":app:compose_article")
include(":app:task_manager")
include(":app:compose_quadrant")
include(":app:dice_roller")
include(":app:tip_calculator")
include(":app:business_card")
include(":app:monday_23")
include(":app:scrollable_list")
include(":app:wednesday_25")
include(":app:lemonade_app")
include(":app:tip_calculator_ver2")
include(":app:number_guessing_game")
