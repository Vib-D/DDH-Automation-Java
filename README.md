# Automation Testing Framework

A Playwright-based automation testing framework built with Java and Maven.

## Technology Stack
- **Playwright**: Browser automation library
- **Java**: Programming language (JDK 11+)
- **Maven**: Build automation
- **JUnit**: Testing framework
- **ExtentReports**: Test reporting
- **Log4j**: Logging

## Project Structure
```
src/
├── main/java/com/vibhor/automation/
├── test/java/com/vibhor/automation/
│   ├── base/              - Base test classes
│   ├── testcases/         - Test case implementations
│   ├── listeners/         - Event listeners
│   └── utilities/         - Helper utilities
└── test/resources/        - Test properties and configurations
```

## Features
- Multi-browser support (Chromium, Firefox, WebKit)
- Centralized configuration management
- Logging and reporting capabilities

## Getting Started
1. Ensure Java 11+ is installed
2. Run `mvn clean test` to execute tests

## Main Components
- **BaseTest**: Base class for all test cases with browser setup/teardown
- **OR.properties**: Object repository for locators
- **log4j.properties**: Logging configuration

