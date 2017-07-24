# ratauth

Ratpack/MongoDB based Oauth2 server.

Build with: 

`./gradlew build`

Add to Jenkins via Pipeline task using `Jenkinsfile` (make sure you have Docker installed on Jenkins machine)

For development run MongoDB with:

`docker run --name mongo_dev --rm -d -p 27017:27017 mongo`

stop it with:

`docker stop mongo_dev`

