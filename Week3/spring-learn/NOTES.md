# Hands-on 1 & 4 Notes - Spring Web and Spring Core XML Configurations
## Walkthrough Notes

### 1. Hands-on 1 Setup (Spring Web Project):
- Artifact ID: `spring-learn`
- Group ID: `com.cognizant`
- Dependencies selected:
  - `Spring Boot DevTools`
  - `Spring Web`
- Built using `mvn clean package` command.
- Verified logger setup showing `Inside main` in console logs.

---

### 2. Hands-on 4 Core XML Configuration:
- Configured a bean of class `com.cognizant.springlearn.Country` with ID `country` in `src/main/resources/country.xml`.
- Initialized properties using:
  ```xml
  <property name="code" value="IN" />
  <property name="name" value="India" />
  ```
- Logger levels configuration set in `application.properties` to print `DEBUG` logs from `com.cognizant` package.

---

### 3. SME Walkthrough Questions & Answers:

**Q: What is the purpose of the @SpringBootApplication annotation?**
- It marks the main class of the project. It bundles three annotations:
  - `@Configuration`: Allows defining and registering extra beans via Java configuration.
  - `@EnableAutoConfiguration`: Automatically configures beans depending on library jar dependencies on the classpath (e.g. configures Tomcat web server automatically because `spring-boot-starter-web` is on the classpath).
  - `@ComponentScan`: Tells Spring to automatically search the package of this class (and subpackages) for components like `@Component`, `@Service`, `@RestController`.

**Q: What does ClassPathXmlApplicationContext do?**
- It is a container class that implements `ApplicationContext` and builds the Spring Container by reading bean configurations from an XML configuration file located on the classpath (like `src/main/resources/country.xml`).

**Q: What exactly happens when context.getBean() is invoked?**
- Spring looks up the bean registry for the specified ID (like `"country"`). If found, it fetches the pre-instantiated singleton bean (or instantiates it on-demand if set to prototype scope) and returns it. If class cast checking is requested (e.g., `context.getBean("country", Country.class)`), Spring verifies if the bean is compatible with that type, else throws a `BeanNotOfRequiredTypeException`.

**Q: In what order are constructors and getters/setters called during bean creation?**
1. First, ClassPathXmlApplicationContext reads the XML.
2. It instantiates `Country` using the default constructor (`Inside Country Constructor.` is logged).
3. Then, it sets the values configured in `<property>` tags by invoking setter methods (`Inside setCode method` and `Inside setName method` are logged).
4. Getter methods are invoked only when we fetch properties from code afterwards.
