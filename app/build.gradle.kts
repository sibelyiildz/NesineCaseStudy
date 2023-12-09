plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Configs.NAME_SPACE
    compileSdk = Configs.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = Configs.APPLICATION_ID
        minSdk = Configs.MIN_SDK_VERSION
        targetSdk = Configs.TARGET_SDK_VERSION
        versionCode = Configs.VERSION_CODE
        versionName = Configs.VERSION_NAME

        testInstrumentationRunner = Configs.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        debug {
            versionNameSuffix = "-dev"
        }
        release {
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
}

dependencies {

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APP_COMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAINT)
    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.TEST_EXT)
    androidTestImplementation(Dependencies.ESPRESSO)

    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)

    implementation(Dependencies.GLIDE)

    implementation(Dependencies.RETROFIT)

    implementation(Dependencies.GSON)
    implementation(Dependencies.RETROFIT_GSON)

    implementation(Dependencies.OKHTTP_LOGGER)
    implementation(Dependencies.CHUCKER)

    implementation(Dependencies.COROUTINES_ANDROID)

}