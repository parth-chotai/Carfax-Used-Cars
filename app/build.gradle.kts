import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

val secretsProperties = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "secrets.properties")))
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    defaultConfig {
        applicationId = Android.appId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = CarfaxApp.versionCode
        versionName = CarfaxApp.versionName

        testInstrumentationRunner = Android.testInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "BASE_URL", "\"" + secretsProperties["BASE_URL"] + "\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }

    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
}

dependencies {
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.tooling)
    implementation(Compose.activity)
    implementation(ComposeTest.uiTestJunit4)
    implementation(ComposeTest.uiTestManifest)
    implementation(AndroidX.lifecycleRuntimeKtx)
    testImplementation(Junit.junit4)
    androidTestImplementation(Junit.junitExt)
    implementation(Compose.navigation)

    // Coil
    implementation(Coil.coil)
    implementation(Coil.coilGif)

    // Accompanist
    implementation(Accompanist.animations)
    implementation(Accompanist.permissions)

    // Debug profiling
    implementation(Compose.ui_tooling)
    debugImplementation(Compose.ui_tooling_preview)

    // Dagger - Hilt
    implementation(DaggerHilt.daggerHilt)
    implementation(DaggerHilt.hiltNavigation)
    kapt(DaggerHilt.kaptDaggerHiltCompiler)
    kapt(DaggerHilt.kaptHiltCompiler)

    // Retrofit
    implementation(Retrofit.retrofit)
    implementation(Retrofit.retrofitGsonConverter)
}