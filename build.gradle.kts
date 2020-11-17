plugins {
    `maven-publish`
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    `java-library`
    id("com.jfrog.bintray") version "1.8.5"
}

repositories {
    jcenter()
}

group = "dev.mfazio.abl"
version = "1.0.2"

val artifactName = project.name
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()
val publicationName = project.name

dependencies {
    val retrofitVersion = "2.9.0"

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

bintray {
    user = System.getenv("bintrayUser")
    key = System.getenv("bintrayKey")
    publish = true

    pkg.apply {
        repo = "android-baseball-league"
        name = artifactName
        userOrg = "mfazio23"
        vcsUrl = "https://github.com/MFazio23/ABL-API-Client"
        setLicenses("Apache-2.0")
        setPublications(publicationName)
    }
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

publishing {
    publications {
        create<MavenPublication>(publicationName) {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion
            from(components["kotlin"])

            artifact(sourcesJar)
        }
    }
}