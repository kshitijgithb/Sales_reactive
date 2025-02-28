package com.kshitij.learnreactive;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
public class EnableReactiveMongoRepositories extends AbstractReactiveMongoConfiguration {
    @Bean
    public MongoClient mongoClient() { //helps to connect with the database
        return MongoClients.create("mongodb://localhost:27017/Kshitij-Kumar");
    }

    @Override
    protected String getDatabaseName() {
        return "Kshitij-Kumar";
    }
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient(), getDatabaseName()); //request a client and connect with database
    }
}
