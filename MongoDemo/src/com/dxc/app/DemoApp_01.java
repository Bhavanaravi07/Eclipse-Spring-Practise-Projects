package com.dxc.app;

import java.util.Set;
import java.util.function.Consumer;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DemoApp_01 {
	
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase = mongoClient.getDatabase("dxc");
		MongoCollection<Document> collection = mongoDatabase.getCollection("employee");
		//MongoCursor<Document> mongoCursor = collection.find().iterator();
		MongoCursor<Document> mongoCursor = collection.find(new Document().append("name", "devi")).iterator();
		mongoCursor.forEachRemaining(DemoApp_01::display);
		//mongoCursor.forEachRemaining(new Consumer<Document>() {
			
			//@Override
			//public void accept (Document document) {
				
				//Set<String> keys = document.keySet();
				//for(String key : keys) {
					//Object value = document.get(key);
					//System.out.println(key+" : "+value);
				//}
				//System.out.println("------------------------------");
			//}
		//});
		
		mongoClient.close();
	}
	
	public static void display (Document document) {
		
		Set<String> keys = document.keySet();
		for(String key : keys) {
			Object value = document.get(key);
			System.out.println(key+" : "+value);
		}
		System.out.println("------------------------------");
	}

}
