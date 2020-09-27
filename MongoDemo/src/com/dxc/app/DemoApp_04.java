package com.dxc.app;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class DemoApp_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase = mongoClient.getDatabase("dxc");
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("employee");
		
		mongoCollection.updateOne(Filters.and(
				                         Filters.eq("name", "Bhavana"),
				                         Filters.eq("dept", "ece")
				                         ),
				                  Updates.set("basicpay", "4000")
				                 );
		
		System.out.println("Document updated successfully");
		
		mongoClient.close();
		
	

	}

}

