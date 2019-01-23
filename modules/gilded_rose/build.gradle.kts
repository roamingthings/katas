import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.10"
}

buildscript {
    extra["kotlinVersion"] = "1.3.11"
    extra["assertjVersion"] = "3.11.1"
    extra["junitVersion"] = "5.3.2"
    extra["mockitoVersion"] = "2.23.4"

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
    }
}

group = "de.egga"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:${extra["junitVersion"]}")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${extra["junitVersion"]}")

    testCompile("org.assertj:assertj-core:${extra["assertjVersion"]}")
    testCompile("org.mockito:mockito-junit-jupiter:${extra["mockitoVersion"]}")
    testCompile("org.mockito:mockito-core:${extra["mockitoVersion"]}")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
