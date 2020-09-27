package com.dxc.dao;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class JdbcDAO {
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	MongoDatabase mongoDatabase = mongoClient.getDatabase("dxc");
	MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("employee");

}
