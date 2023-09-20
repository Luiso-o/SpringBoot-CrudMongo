plugins {
	java
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "cat.itacademy.barcelonactiva.Trujillo.Luis.s04.t02.n03"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.1.3")
	implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
	compileOnly("org.projectlombok:lombok:1.18.26")
	developmentOnly("org.springframework.boot:spring-boot-devtools:3.0.4")
	annotationProcessor("org.projectlombok:lombok:1.18.26")

	testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo:4.7.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
