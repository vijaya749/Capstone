# Selenium Java Automation Framework

## Tools Used
- Java 11
- Selenium WebDriver 4.x
- TestNG 7.x
- Maven
- WebDriverManager (auto browser driver setup)

## Project Structure
```
auto/
├── src/
│   ├── main/java/
│   │   ├── pages/
│   │   │   ├── HomePage.java
│   │   │   ├── CartPage.java
│   │   │   └── CheckoutPage.java
│   │   └── utils/
│   │       ├── DriverFactory.java
│   │       ├── ConfigReader.java
│   │       └── WaitUtils.java
│   └── main/resources/
│       └── config.properties
├── src/test/java/tests/
│   ├── BaseTest.java
│   ├── SearchProductTest.java
│   ├── AddToCartTest.java
│   ├── AddMultipleProductsTest.java
│   ├── PlaceOrderTest.java
│   └── NavigationTest.java
├── testng.xml
├── pom.xml
└── README.md
```

## Test Scenarios
| # | Test Class | Description |
|---|-----------|-------------|
| 1 | SearchProductTest | Search for a product and verify it appears in results |
| 2 | AddToCartTest | Add a product to cart and verify quantity = 1 |
| 3 | AddMultipleProductsTest | Add 2 products and verify cart count and prices |
| 4 | PlaceOrderTest | Full checkout flow with promo code and order confirmation |
| 5 | NavigationTest | Browser back/forward/refresh navigation validation |

## How to Run

### Prerequisites
- Java 11+
- Maven 3.6+
- Chrome browser installed

### Run all tests
```bash
mvn test
```

### Reports
- TestNG report: `target/surefire-reports/index.html`
- Surefire XML: `target/surefire-reports/`

## Configuration
Edit `src/main/resources/config.properties` to change browser or timeouts:
```properties
browser=chrome        # chrome or firefox
baseUrl=https://rahulshettyacademy.com/seleniumPractise/
implicitWait=10
explicitWait=10
```
