package com.microservice.currencyexchangeservice;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongodb.connection.url}")
    private String connectionString;

    @Override
    public MongoClient mongoClient() {

        ConnectionString mongoUri = new ConnectionString(connectionString);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(mongoUri).build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return "currencyExchangeDB";
    }

    @Override
    public Collection getMappingBasePackages(){
        return Collections.singleton("com.microservice.domain");
    }
}
