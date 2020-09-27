package com.dxc.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DemoApp_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase = mongoClient.getDatabase("dxc");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the collection name to insert");
		String collectionName = scanner.next();
		
		if(mongoDatabase.listCollectionNames().into(new ArrayList<String>()).contains(collectionName)) {
			MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(collectionName);
			Document document1 = new Document()
					                .append("name", "Book")
					                .append("title", "Head First Java and OOAD")
					                .append("level", "Fresher to Advanced")
					                .append("pages", 2000);
			
			Document document2 = new Document()
	                                .append("name", "Pen")
	                                .append("title", "Cello")
	                                .append("colour", "Black")
	                                .append("price", 20);
			
			Document document3 = new Document()
	                                .append("name", "Pencil")
	                                .append("title", "Apsara")
	                                .append("price", 10);
			
			List<Document> list = new ArrayList<Document>();
			list.add(document1);
			list.add(document2);
			list.add(document3);
			
			mongoCollection.insertMany(list);
			
			System.out.println("Document inserted successfully");

		}
		else {
			System.out.println("Collection is not existing, first you create a collection and then try!!!");
		}
		
        mongoClient.close();
	}

}
