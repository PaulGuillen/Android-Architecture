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
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.activity)
    implementation(libs.material)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.koin.navigation)
}