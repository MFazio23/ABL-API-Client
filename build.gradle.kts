plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    `java-library`
}

repositories {
    jcenter()
}

dependencies {
    val retrofitVersion = "2.9.0"

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    api("com.squareup.retrofit2:retrofit:$retrofitVersion")


    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
