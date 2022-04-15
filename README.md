
# Books E-Store Project

### Books E-Store Web API APP

This project has an api that you can buy a book or get customers or see the stocks and you can create, update all of these.
This project includes some crud operations and logs these operations, global and special exception handlers, special response entities, bearer authentication, validations, container technologies, open api specification

## Project Structure

![ProjectStructure](https://i.ibb.co/nfVwsTf/Screenshot-2022-04-15-at-10-55-13-Excalidraw.png)


## ER Diagram of Database
![erDiagram](https://i.ibb.co/M1YQvKQ/Screenshot-2022-04-15-112857.png)

## 🛠 Technology Stacks

**Tech Stack:** Java, Spring Boot, MongoDB, MySQL, Keycloak, Docker

**Libraries and Tools:** Spring Data JPA, Spring Security, Lombok, JUnit, Mockito, Powermock, Swagger
## Run Locally

#### Clone the project

```bash
  git clone https://github.com/muslumcanozata/book_store_spr
```

#### Go to the clone project file

```bash
  cd book_store_spr
```

#### Create images with docker

```bash
  docker-compose up
```

#### Start the spring boot project

#### Run this command lines by using Powershell and get the Access Token

```powershell
  $headers = New-Object "System.Collections.Generic.Dictionary[[String],[String]]"
  $headers.Add("Content-Type", "application/x-www-form-urlencoded")
  $body = "grant_type=password&client_id=book_store_spring&client_secret=8FVgmzeYyVWkkxp24mn6PEICGn4NaxYW&username=employee3&password=Password1"
  $response = Invoke-RestMethod 'http://localhost:8080/auth/realms/book_store_spring/protocol/openid-connect/token' -Method 'POST' -Headers $headers -Body $body
  $response | ConvertTo-Json
```

#### Now, you can fetch the data by using swagger after you get an authorization with this access token

```
  http://localhost:8000/swagger-ui.html#
```
## Author

- [@muslumcanozata](https://github.com/muslumcanozata)




## References

 - [Keycloak With Docker](https://github.com/keycloak/keycloak-containers/blob/main/docker-compose-examples)
 - [Keycloak Tutorial](https://medium.com/devops-dudes/securing-spring-boot-rest-apis-with-keycloak-1d760b2004e)
 - [Swagger With JWT](https://www.baeldung.com/spring-boot-swagger-jwt)
 - [Mongodb Documentation](https://docs.mongodb.com/manual/introduction/)
