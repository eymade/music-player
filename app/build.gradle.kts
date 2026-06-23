plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.androidx.navigation.safeargs)
    id("org.jetbrains.kotlin.plugin.parcelize")
    alias(libs.plugins.google.devtools.ksp)
}

android {
    compileSdk = 35
    namespace = "code.name.monkey.retromusic"
    defaultConfig {
        minSdk = 24
        targetSdk = 36
        vectorDrawables {
            useSupportLibrary = true
        }
        applicationId = "com.example.musicplayer"
        versionCode = 10660
        versionName = "6.6.0"
        buildConfigField("String", "GOOGLE_PLAY_LICENSING_KEY", "\"\"")
    }
    buildTypes {
        debug {
            isMinifyEnabled = false
        }
    }
    flavorDimensions += "version"
    productFlavors {
        create("normal") {
            dimension = "version"
        }
        create("fdroid") {
            dimension = "version"
        }
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += listOf(
                "META-INF/LICENSE",
                "META-INF/NOTICE",
                "META-INF/java.properties"
            )
        }
    }
    lint {
        abortOnError = false
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
    configurations.configureEach {
        resolutionStrategy.force("com.google.code.findbugs:jsr305:1.3.9")
    }
}

dependencies {
    implementation(project(":appthemehelper"))
    implementation(libs.gridLayout)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.preference.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.palette.ktx)
    implementation(libs.androidx.mediarouter)
    implementation(libs.nanohttpd)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.common.java8)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.android.material)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.afollestad.material.dialogs.core)
    implementation(libs.afollestad.material.dialogs.input)
    implementation(libs.afollestad.material.dialogs.color)
    implementation(libs.afollestad.material.cab)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.glide)
    ksp(libs.glide.ksp)
    implementation(libs.glide.okhttp3.integration)
    implementation(libs.advrecyclerview)
    implementation(libs.fadingedgelayout)
    implementation(libs.keyboardvisibilityevent)
    implementation(libs.jetradarmobile.android.snowfall)
    implementation(libs.chrisbanes.insetter)
    implementation(libs.org.eclipse.egit.github.core)
    implementation(libs.jaudiotagger)
    implementation(libs.slidableactivity)
    implementation(libs.material.intro)
    implementation(libs.fastscroll.library)
    implementation(libs.customactivityoncrash)
    implementation(libs.tankery.circularSeekBar)
    implementation(libs.androidx.exoplayer)
    "normalImplementation"(libs.google.play.services.cast.framework)
    "normalImplementation"(libs.google.play.billing)
}
