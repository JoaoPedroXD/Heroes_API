## Executar dynamo: 

## MAC:
    java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
 
## Windows 10:
    java -Djava --class-path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

## Comando em ambas as plataformas:
    aws dynamodb list-tables --endpoint-url http://localhost:8000

## Swagger: 
Para acessar a documentação no Swagger [[Clique aqui.]]("http://localhost:8080/swagger-ui-heroes-reactive-api.html")
