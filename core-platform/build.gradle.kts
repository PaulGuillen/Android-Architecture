import dependence.retrofitImplementation
import dependence.uiCoreLibsImplementation

plugins {
    id("plugin.android.lib")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.devpaul.core_platform"
}

dependencies {
    implementation(project(":core-domain"))
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.activity)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.koin.navigation)
    uiCoreLibsImplementation()
    retrofitImplementation()
}