# them-apples
api for getting back a random list of simple apple objects, with filtering

## prereqs
this is a java spring boot application, to compile and run it you should have JDK 1.8 or above installed (maybe 1.11 or above not sure)
you should also have gradle for building
all of my examples for usage will be using httpie, so if you want to make the requests the same way you cna install that at https://httpie.org/

## build
``` ./gradlew clean build bootRun```

## use
GET, every time you get the apples resource you get a new random list of 10 apples 
``` http localhost:8080/apples ```

GET with filters. filters can be applied cumulatively, only two request parameters available are weightAbove and color
``` http localhost:8080/apples weightAbove==4 color=green ```
