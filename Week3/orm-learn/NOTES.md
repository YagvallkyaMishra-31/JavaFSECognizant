# Hands-on 1 - Spring Data JPA Quick Example
## Setup Notes

### Pre-requisites installed:
- MySQL Server 8.0
- MySQL Workbench 8
- Eclipse IDE for Enterprise Java Developers
- Maven 3.6.2

---

### Project Creation Steps (Spring Initializr):
1. Went to https://start.spring.io/
2. Changed Group to: com.cognizant
3. Artifact Id: orm-learn
4. Description: Demo project for Spring Data JPA and Hibernate
5. Added dependencies:
   - Spring Boot DevTools
   - Spring Data JPA
   - MySQL Driver
6. Downloaded and extracted the zip, imported into Eclipse

---

### MySQL Setup:
Created the schema manually using MySQL client:
```
mysql -u root -p
mysql> create schema ormlearn;
```

---

### Project Structure (SME Walkthrough Notes):

**src/main/java**
- This is where all our actual Java code goes
- Spring Boot scans this folder automatically for @Component, @Service, @Repository etc.

**src/main/resources**
- application.properties lives here — all our config (DB URL, logging, JPA settings)

**src/test/java**
- Test classes go here — kept separate from main code

**OrmLearnApplication.java**
- The entry point — has the main() method
- @SpringBootApplication annotation does 3 things at once:
  1. @Configuration — makes it a config class
  2. @EnableAutoConfiguration — Spring Boot auto-wires things based on what's on the classpath
  3. @ComponentScan — scans the package for beans

**pom.xml**
- spring-boot-starter-parent handles all version numbers for Spring deps
- spring-boot-starter-data-jpa pulls in Hibernate + Spring Data
- mysql-connector-java is the JDBC driver for MySQL
- Dependency Hierarchy in Eclipse shows us the full tree of transitive deps

---

### Key Config in application.properties:
- `ddl-auto=validate` — Hibernate checks tables match our entity classes (doesn't create/drop)
- `logging.level.org.hibernate.SQL=trace` — Shows the actual SQL queries fired
- `logging.level.org.hibernate.type.descriptor.sql=trace` — Shows query param values

---

### Verification:
After running OrmLearnApplication.java, checked the console logs:
- Looked for "Inside main" in the log output
- If it appears, the SpringApplication.run() completed successfully
