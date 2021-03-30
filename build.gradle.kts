import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.4.31"
  id("org.jetbrains.compose") version "0.4.0-build177"
}

group = "ml.demidko"
version = "1.0.0"

repositories {
  jcenter()
  mavenCentral()
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
  testImplementation("com.natpryce:hamkrest:1.8.0.1")
  testImplementation("io.mockk:mockk:1.10.6")
  implementation(compose.desktop.currentOs)
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "11"
}

compose.desktop {
  application {
    mainClass = "MainKt"
    nativeDistributions {
      targetFormats(Dmg, Msi, Deb)
      packageName = "Desktop"
    }
  }
}