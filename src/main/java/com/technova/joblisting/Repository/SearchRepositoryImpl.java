package com.technova.joblisting.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.technova.joblisting.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository
{
    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Job> findByText(String text) {
        final List<Job> jobs = new  ArrayList<>();

        MongoDatabase database = client.getDatabase("telusko");
        MongoCollection<org.bson.Document> collection = database.getCollection("joblisting");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("id","profile", "techs", "desc")))),
        new Document("$sort",
        new Document("exp",1L)),
        new Document("$limit",5L)));


        result.forEach(doc -> jobs.add(converter.read(Job.class, doc)));
        return jobs;
    }
}
