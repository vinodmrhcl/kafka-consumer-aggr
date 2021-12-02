# Sample Microservice for consuming kafka event

## Domain
Toll Service

## Entities
- TollPlaza
- Lanes
- Vehicle
- TollTransactions
- TollTxnSummary

## Endpoints

### Toll Plazas
- GET /plazas - Get All Plazas
- GET /plazas/{plazaId} - Get Plaza by Id
- GET /lanes - Get All Lanes
- GET /plazas/{plazaId]/lanes - Get All Lanes by Plaza Id

### Vehicles
- GET /vehicles - Get All Vehicles

### Toll Transactions
- POST /transactions - Create Transactions
- GET /transactions - Get All Transactions
- GET /transactions?size=2&orderBy=txnTime - Get Top n Transactions by txnTime
- GET /transactions/vehicle/{seqNo} - Get transaction by Vehicle Seq No
- GET /txnSummary - Get All Transaction Summary
- GET /txnSummary/vehicle/{seqNo} - Get Transactions Summary by Vehicle Seq No


## Pre-requiste
- Install [Maven](https://maven.apache.org/install.html) or [Gradle](https://gradle.org/install/)
- Install [KeyCloak](https://www.keycloak.org/getting-started/getting-started-zip)

## KeyCloak Setup
 - Reference - - (https://medium.com/@bcarunmail/securing-rest-api-using-keycloak-and-spring-oauth2-6ddf3a1efcc2)

1. Create Admin User - http://localhost:8080/auth
2. Login to the admin console - http://localhost:8080/auth/admin
3. Create a realm
4. Add Client

`Client ID       : <your_client_name>`
`Client Protocol : openid-connect`

5. Configure Client
 
`Access Type         : confidential`
`Valid Redirect URIs : http://localhost:8085`

6. Create Client Role
7. Create a Mapper

`Property : username`
`Token Claim Name : user_name`
`Add to Access Token : true `

8. Create a user and Set Password
9. Map Client Role To User
10. Get Configuration From OpenID Configuration Endpoint

`GET http://localhost:8080/auth/realms/dev/.well-known/openid-configuration`


## Build
  `mvn clean compile`
  `gradle build`

## Run
  `mvn spring-boot:run`
  `gradle run`
  
## Test
   Use [Postman Suite](Toll%20Service.postman_collection.json)
