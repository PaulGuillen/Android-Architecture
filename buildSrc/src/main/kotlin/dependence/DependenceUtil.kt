package dependence

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.api.provider.Provider
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.kotlin.dsl.dependencies

fun Project.getLibs(): VersionCatalog =
    extensions.getByType<VersionCatalogsExtension>().named("libs")

operator fun VersionCatalog.get(alias: String): Provider<MinimalExternalModuleDependency> {
    return findLibrary(alias).get()
}

fun Project.datastoreImplementation() {
    val libs: VersionCatalog = getLibs()
    dependencies {
        "implementation"(libs["datastore-preferences"])
        "implementation"(libs["datastore-core"])
    }
}

fun Project.koinImplementation() {
    val libs: VersionCatalog = getLibs()
    dependencies {
        "implementation"(libs["koin"])
        "implementation"(libs["koin-annotations"])
        "ksp"(libs["koin-compiler"])
    }
}

fun Project.uiCoreLibsImplementation() {
    val libs: VersionCatalog = getLibs()
    dependencies {
        "implementation"(libs["material"])
        "implementation"(libs["glide"])
        "implementation"(libs["androidx-appcompat"])
        "implementation"(libs["androidx-fragment"])
        "implementation"(libs["androidx-activity"])
    }
}

fun Project.androidCoreImplementation() {
    val libs: VersionCatalog = getLibs()
    dependencies {
        "implementation"(libs["jwtdecode"])
        "implementation"(libs["timber"])
        "implementation"(libs["androidx-core-ktx"])
        "implementation"(libs["androidx-lifecycle-runtime-ktx"])
    }
}

fun Project.navigationFragmentImplementation() {
    val libs: VersionCatalog = getLibs()
    dependencies {
        "implementation"(libs["navigation-fragment"])
        "implementation"(libs["navigation-ui"])
        "implementation"(libs["kotlinx-serialization-json"])
    }
}

fun Project.androidTestingImplementation() {
    val libs: VersionCatalog = getLibs()
    dependencies {
        "testImplementation"(libs["junit"])
        "androidTestImplementation"(libs["androidx-junit"])
        "androidTestImplementation"(libs["androidx-espresso-core"])
        "testImplementation"(libs["mockito-core"])
        "testImplementation"(libs["mockito-inline"])
    }
}

fun Project.retrofitImplementation() {
    val libs: VersionCatalog = getLibs()
    dependencies {
        "implementation"(libs["retrofit"])
        "implementation"(libs["retrofit-converter-gson"])
        "implementation"(libs["okhttp3-loggin-interceptor"])
    }
}
