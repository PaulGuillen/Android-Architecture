plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.android.application.gradle)
    implementation(libs.jetbrains.kotlin.android.gradle)
    implementation(libs.google.ksp.gradle)
    implementation(libs.jetbrains.kotlin.gradle)
    implementation(libs.navigation.safe.args.gradle.plugin)
    implementation(libs.kotlinx.serialization.gradle.plugin)
}