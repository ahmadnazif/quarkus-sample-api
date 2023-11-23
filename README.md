# quarkus-sample-api

This is a simple API server that build using Quarkus 3.5.3. I've also built the similiar API server using:
- [NodeJS](https://github.com/ahmadnazif/nodejs-sample-api)
- [.NET](https://github.com/ahmadnazif/aspnetcore-aot-sample-api)

## Data Storage
No external library is used. Instead, a singleton reference is created each time app started and hold the data temporarly in memory. You can see it in `services/db.java`

## Running sample using VS Code
- Clone this repo
- Open the sample using
- Rebuild cache: `./gradlew --build-cache`
- Run: `./gradlew quarkusDev`
