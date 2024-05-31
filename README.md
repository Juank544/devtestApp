# DevTestApp
This app provides info about employees either from an API that you can consume with Postman, and also brings a simple web client where the data is fetched.

The backend was developed using object-oriented programming following good design and coding practices, using principles as SOLID, KISS and DRY, it has a structure where you can find the business layer, model layer and controller layer using dependency injection between them, each service uses the Singleton pattern in the context of Spring to be available for use. The backend also handle the common exceptions in a global controller class, just to give better responses to the client.

The frontend was based on Bootstrap, importing the common js and css files to get a simple but friendly interface easy to use, it provides 3 views, the index, the table, and one for the errors, it comes along Thymeleaf, used to populate the fields with the data fetched from the backend.

## SetUp

1. Run the **build** task of Gradle to assemble a WAR executable that will be load to a container:

   `./gradlew build`

2. Using the Dockerfile build the image of the app:
   
   `docker build -t idevtest .`

3. Run a container using the image that was created previously, the backend won't work without an environment variable (hardcode anti-pattern):
   
   `docker run --name cdevtest -p 8080:8080 --env API_KEY=http://dummy.restapiexample.com/api/v1 idevtest`

4. Go to http://localhost:8080
5. Enjoy!