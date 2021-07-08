# Merge intervals service (proof of concept)

Service capable of merging given intervals. PoC, not intended for production use.

Imaging given intervals [25,30] [2,19] [14, 23] [4,8], which you want to merge to
the intervals  [2,23] [25,30].

This services provides an endpoint

    POST /merge-intervals

for exactly doing this.

## Running the application in dev mode

- Prerequisite: JDK16

```
### Start (Quarkus) application
./gradlew quarkusDev
```

> **_NOTE:_** Visit http://localhost:8080/q/swagger-ui for reading as well as using the API.

## Merge algorithm

If you are interested in the merge alogrithm, have a look at 
[IntervalsMerger](src/main/java/service/intervals/IntervalsMerger.java).

## Further improvements

This service is intended to be a proof of concept, not ready for production.
Besides the existing open [issues](issues) there is still production rdy functionality missing
such as user input validation, error handling, logging etc.