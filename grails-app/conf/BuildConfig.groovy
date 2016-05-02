grails.project.work.dir = 'target'
grails.project.docs.output.dir = "docs"

grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {

    inherits "global"
    log "warn"

    repositories {
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    plugins {
        compile ":rest-client-builder:2.1.1"
    }

    dependencies {
        compile("org.apache.maven:maven-ant-tasks:2.1.3") {
            excludes "commons-logging", "xml-apis", "groovy"
        }
        test("org.gmock:gmock:0.8.3") {
            excludes "org.codehaus.groovy:groovy-all", "groovy-all", "groovy"
            export = false
        }
    }
}
