object PluginDependencies {
    val android = "com.android.tools.build:gradle:${Versions.gradleAndroidPlugin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object ProjectModules {
    val data = ":data"
    val domain = ":domain"
}

object ProjectDependencies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
    val ktlint = "com.github.shyiko:ktlint:${Versions.ktlint}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerAnnotationProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val javaInject = "javax.inject:javax.inject:${Versions.javaxInject}"

    val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    val supportAppCompat = "com.android.support:appcompat-v7:${Versions.appcompat}"
}

object TestProjectDependencies {
    val junit = "junit:junit:${Versions.junit}"
    val assertJ = "org.assertj:assertj-core:${Versions.assertJ}"
    val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    val mockitoKotlin = "com.nhaarman:mockito-kotlin:${Versions.mockitoKotlin}"
    val androidTestRunner = "com.android.support.test:runner:${Versions.androidTestRunner}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}