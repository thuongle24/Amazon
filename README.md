# Amazon
## 1. Build Configuration file, written as either with Apache Maven pom.xml file or a Gradle build.gradle file to set up all the third party dependencies. 
## 2. Test script classes written in frameworks such as JUnit to execute the tests. 
## 3. Webdriver configuration & Environment-specific configurations
### In particular, Serenity uses the serenity.conf file to setup these configs in the src/test/resources
## 4. Getting Started with Serenity BDD Framework
### These components run Serenity BDD Framework. They are all required.
- Java
- IntelliJ IDE (or Eclipse)
- JUnit
- Gradle or Maven (I'm using Maven) https://maven.apache.org/download.cgi
- Serenity BDD Plugin
## 5. Running Your First Test
- Before run, open the actor_info.json file under /resources/Json folder, input the credentials + environment (there is only one environment, so I put 'default')
- Run the test in /NVG/Amazon/src/test/java/automation/amazon/testcases/amazon
- See report in html in {machine_path}/Amazon/target/site/reports

