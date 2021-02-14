package com.digitalinnovation.livecoding.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.digitalinnovation.livecoding.document.Heroes;

import java.util.ArrayList;

import static com.digitalinnovation.livecoding.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovation.livecoding.constants.HeroesConstant.REGION_DYNAMO;

public class HeroesData {
    public static void main(String[] args) {
        //Client que acessa o DynamoDB
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        //Variável que acessa o banco de dados
        DynamoDB dynamoDB = new DynamoDB(client);
        //Define a tabela a ser utilizada
        Table table = dynamoDB.getTable("Heroes_Api_Table");

        //Informa os itens
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Mulher Maravilha")
                .withString("universe", "dc comics")
                .withNumber("films", 2));
        items.add(new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Viuva negra")
                .withString("universe", "marvel")
                .withNumber("films", 2));
        items.add(new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Capita marvel")
                .withString("universe", "marvel")
                .withNumber("films", 2));

        //Insere as informações acima no banco para fins de teste
        items.forEach(table::putItem);
    }
}

