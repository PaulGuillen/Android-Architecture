plugins {
    id("plugin.application")
}

android {
    namespace = "com.devpaul.android_architecture"

    defaultConfig {
        applicationId = "com.devpaul.android_architecture"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":navigation"))
    implementation(project(":core-platform"))
    implementation(project(":core-data"))
    implementation(project(":core-domain"))
    implementation(project(":feature:auth"))
    implementation(project(":feature:util"))
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.activity)
    implementation(libs.material)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.koin.navigation)
}