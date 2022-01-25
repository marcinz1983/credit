
### Stack :rocket:
- Java
- Spring
- Hibernate
- Maven
- Git

### Path to schema DB (H2)
 - credit\src\main\resources\db\migration\h2

### Rest end point  "create credit" at url address:
 - http://localhost:8080/api/credit/add
 - Request method 'POST'
    * query json format example:
   
      * {
      * 
        "name":"Marcin",
      * 
        "surname":"Marcin",
      * 
        "pesel": "87071668265",
      * 
        "creditName":"Hipoteka",
      * 
        "value" : 50000
      * 
        }
    * End point response json format example :
      * 
       {
      
       "creditId":56
   
      {

### Rest end point  "get credits" at url address:
- http://localhost:8080/api/credit/getAll
- Request method 'GET'
    * no query parameters
    * 
    * End point response json format example :
    * 
     *{

       "GetCreditsResponse":[
                             {
                               "name" : "Marcin",
                               "surname" : "Marcin",
                               "pesel" : "87071668265",
                               "creditName2 : "Hipoteka",
                               "value" : 5000,
                               "creditId" : 1
                              }
                             ]
     }