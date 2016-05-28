package com.mobilapi.configuration;


import com.mongodb.*;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class MongoDBConfiguration {

    @Value("${mongodb.host}")
    public String DB_HOST;

    @Value("${mongodb.port}")
    public int DB_PORT;

    @Value("${mongodb.db.name}")
    public String DB_NAME;

    @Value("${mongodb.userName}")
    public String DB_USERNAME;

    @Value("${mongodb.password}")
    public String DB_PASSWORD;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MongoDBConfiguration.class);


    @Bean
    public Datastore datastore() throws UnknownHostException {

        Datastore datastore;

        MongoClientOptions mongoOptions = MongoClientOptions.builder()
                .socketTimeout(60000) // Wait 1m for a query to finish, https://jira.mongodb.org/browse/JAVA-1076
                .connectTimeout(15000) // Try the initial connection for 15s, http://blog.mongolab.com/2013/10/do-you-want-a-timeout/
                .maxConnectionIdleTime(600000) // Keep idle connections for 10m, so we discard failed connections quickly
                .readPreference(ReadPreference.primaryPreferred()) // Read from the primary, if not available use a secondary
                .build();

        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(DB_USERNAME, DB_NAME, DB_PASSWORD.toCharArray());

        List<MongoCredential> credentialsList = new ArrayList<>();
        credentialsList.add(mongoCredential);

        MongoClient mongoClient = new MongoClient(new ServerAddress(DB_HOST, DB_PORT), credentialsList, mongoOptions);

        mongoClient.setWriteConcern(WriteConcern.SAFE);
        datastore = new Morphia().mapPackage("com.mobilapi.domain").createDatastore(mongoClient, DB_NAME);
        datastore.ensureIndexes();
        datastore.ensureCaps();
        LOGGER.info("Connection to database '" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "' initialized");

        return datastore;

    }
}

