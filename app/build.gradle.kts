plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    /*
    id ("kotlin-kapt")*/
    id("org.jetbrains.kotlin.kapt")
    id("kotlin-android")

}


android {
    namespace = "com.example.sampleapplications"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.sampleapplications"
        minSdk = 21
        targetSdk = 29
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:1.7.0")
    implementation("androidx.activity:activity-compose:1.6.7")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.ar.sceneform:filament-android:1.17.1")
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.google.firebase:firebase-messaging:23.4.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    debugImplementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.android.volley:volley-cronet:1.2.1")
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.google.code.gson:gson:2.4")
    implementation("com.github.bumptech.glide:glide:4.12.0")


    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")


    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries

    /*    implementation("androidx.test.ext:junit:1.1.2")
        implementation("androidx.test.espresso:espresso-core:3.3.0")
        implementation("androidx.test:runner:1.3.0")
        implementation("androidx.test:rules:1.3.0")*/

    /*    implementation("com.google.zxing:core:3.2.1")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("io.realm:realm-gradle-plugin:10.10.1")*/
    //  un comment aove set

    //implementation("io.realm:android-adapters:2.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    implementation("com.google.zxing:core:3.2.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("io.realm.kotlin:library-base:0.10.0")
    //implementation("io.realm:realm-android-gradle-plugin:10.10.0")
    //implementation(libs.realm.library)
    // implementation(libs.realm.library)
    implementation("io.realm.kotlin:library-base:1.6.1")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    //  implementation("io.realm:realm-gradle-plugin:10.13.3-transformer-api")

    implementation("io.realm:realm-android-library:10.13.0")
    // implementation ("io.realm:android-adapters:4.0.0")
    // implementation("io.realm:android-adapters:3.1.0")
    //implementation ("com.github.realm:realm-android-adapters:3.1.0")
    // implementation ("androidx.multidex:multidex:2.0.1")
    implementation("com.android.support:multidex:1.0.3")
    implementation("androidx.biometric:biometric:1.0.1")
    implementation("com.google.zxing:core:3.4.1")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")


}