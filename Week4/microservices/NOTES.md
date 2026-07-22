# Microservices - Account and Loan

## What are Microservices?

Microservices is an architectural style where an application is built as a collection of small, 
independent services. Each service runs in its own process, is independently deployable, 
and communicates with other services via lightweight mechanisms (usually REST APIs over HTTP).

## Why Microservices instead of Monolithic?

In a monolithic approach both account and loan modules would be in one single application. 
If one module crashes the whole application goes down. With microservices, each module is a 
separate Spring Boot application. If account service goes down, loan service is still running.

Some advantages:
- **Independent deployment** - We can deploy account service without touching loan service
- **Independent scaling** - If account service gets more traffic, we can scale just that
- **Technology flexibility** - Each service can use different database or tech stack
- **Fault isolation** - Failure in one service doesn't bring down everything

## Hands-on Implementation

### Account Microservice (Port 8080)
- Created using Spring Initializr with Spring Web and DevTools
- Group: com.cognizant, Artifact: account
- REST endpoint: GET /accounts/{number}
- Returns dummy JSON response: `{ number, type, balance }`
- Runs on default port 8080

### Loan Microservice (Port 8081)
- Same setup as Account but different artifact name
- REST endpoint: GET /loans/{number}
- Returns dummy JSON response: `{ number, type, loan, emi, tenure }`
- Initially tried starting on 8080 → failed with "Address already in use" error
- Added `server.port=8081` in application.properties to fix this

### Port Conflict Issue
When I first tried to run loan service while account was already running on 8080, 
I got this error:
```
Web server failed to start. Port 8080 was already in use.
Action: Identify and stop the process that's listening on port 8080 or configure 
this application to listen on another port.
```
Fixed by setting `server.port=8081` in loan's application.properties.

### Testing
- Account service: http://localhost:8080/accounts/00987987973432
  - Response: `{"number":"00987987973432","type":"savings","balance":234343}`
- Loan service: http://localhost:8081/loans/H00987987972342
  - Response: `{"number":"H00987987972342","type":"car","loan":400000,"emi":3258,"tenure":18}`

### Eclipse Console Note
When running both services in Eclipse, the console view shows both application outputs.
We can switch between different consoles using the monitor icon (Display Selected Console) 
within the Console view. Each running application gets its own console tab.

## Key Observations
1. Each microservice has its own pom.xml - completely independent projects
2. Each service has its own main application class annotated with @SpringBootApplication
3. Both use SLF4J logging with start/end log statements in controller methods
4. The only difference from a monolith is the separation into two Spring Boot apps
5. Each can be started, stopped, and deployed independently
