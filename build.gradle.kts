plugins {
    java
    application
}

group = "cz.hoffic.fundappsdemo"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

application {
    mainClassName = "cz.hoffic.fundappsdemo.Main"
}
