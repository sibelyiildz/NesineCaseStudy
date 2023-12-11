object Dependencies {
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Androidx.APP_COMPAT}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.Androidx.CORE_KTX}"

    private const val NAVIGATION = "androidx.navigation:navigation-"
    const val NAVIGATION_FRAGMENT = "${NAVIGATION}fragment-ktx:${Versions.Androidx.NAVIGATION}"
    const val NAVIGATION_UI = "${NAVIGATION}ui-ktx:${Versions.Androidx.NAVIGATION}"
    const val NAVIGATION_SAFE_ARGS =
        "${NAVIGATION}safe-args-gradle-plugin:${Versions.Androidx.NAVIGATION_SAFE_ARGS}"

    private const val LIFECYCLE = "androidx.lifecycle:lifecycle-"
    const val LIFECYCLE_VIEW_MODEL = "${LIFECYCLE}viewmodel-ktx:${Versions.Androidx.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA = "${LIFECYCLE}livedata-ktx:${Versions.Androidx.LIFECYCLE}"

    const val SUPPORT_LEGACY =
        "androidx.legacy:legacy-support-v4:${Versions.Androidx.SUPPORT_LEGACY}"

    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL_ANDROID}"
    const val CONSTRAINT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT}"

    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"

    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP3}"
    const val CHUCKER = "com.github.chuckerteam.chucker:library:${Versions.CHUCKER}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_GSON}"
    const val RETROFIT_RXJAVA = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT}"

    const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.RX_JAVA}"

    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID}"

    const val JUNIT = "junit:junit:${Versions.JUNIT4}"
    const val TEST_EXT = "androidx.test.ext:junit:${Versions.TEST_EXT}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    private const val HILT = "com.google.dagger:hilt-"
    const val HILT_ANDROID = "${HILT}android:${Versions.HILT}"
    const val HILT_COMPILER = "${HILT}compiler:${Versions.HILT}"

    const val LOTTIE = "com.airbnb.android:lottie:${Versions.LOTTIE}"

}