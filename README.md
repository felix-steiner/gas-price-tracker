[![Java CI with Gradle](https://github.com/felix-steiner/gas-price-tracker/actions/workflows/gradle.yml/badge.svg)](https://github.com/felix-steiner/gas-price-tracker/actions/workflows/gradle.yml)
# Gas Price Tracker ⛽
The Gas Price Tracker is a simple Java application, which periodically performs API calls for gathering information about gas prices around your area. This data is stored in a PostgreSQL database and can be accessed via a REST API made with Spring. Both Java application and database can be deployed using Docker 🐳.

## Usage 🔥
The main aim of this project is to gather information about the gas prices around your area. Consequently, you can get some insights e.g. what time of the day it's usually the cheapest to buy gas or which gas station is the cheapest one. For optimal data gathering it is recommended to run this software on a server (e.g. a Raspberry Pi), which is running continuously.

💡 Note: It's only possible to track gas stations, which are located in Austria.

## Getting Started 🚀
### Prerequisites
- Git installed
- Docker installed
- Docker compose installed

### Steps
1. Open a terminal and clone the repository
2. Switch into the _gas-price-tracker_ directory
3. Optional: Switch into the _api-service_ directory and run `gradlew build` for building a new .jar file
4. Run `docker-compose up` in your terminal
5. The Gas Price Tracker app should be up and running now 😄

- Frontend: `localhost:80`
- Backend: `localhost:8080/gas-prices` or `localhost:8080/gas-prices/chart`

## Configuration ⚙
The `application.properties` file (located in `src/main/resources`) allows you to make some configurations:
- `lat`: Latitude of your position
- `lon`: Longitude of your position
- `rate`: The rate (in milliseconds) how often the Java application makes an API call for retrieving new gas price data (e.g. hourly: 3600000)
