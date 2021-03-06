package test;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.text.Document;

import org.bson.BasicBSONObject;

import static java.util.concurrent.TimeUnit.SECONDS;
public class mongodb
{
	public mongodb(){
		
	}
	
	public String selectSingleRecordAndFieldByRecordNumber(DBCollection collection) {
		BasicDBObject field = new BasicDBObject("href","coap://[aaaa::444f:4f50:a729:142c]:5683/pwr/w");
		DBCursor cursor = collection.find(field);
		String val = "";
		while (cursor.hasNext()) {
			BasicDBObject result = (BasicDBObject) cursor.next();
			int i = result.size();
			System.out.println("Result Size: "+i);
			System.out.println(result);
			ArrayList<BasicDBObject> versions = (ArrayList<BasicDBObject>)result.get("i-object-metadata"); // * See Note
			for(BasicDBObject embedded : versions){
				val = (String)embedded.get("val");
				System.out.println("val : " + val);}
		}
	      return val;  
		
		
	    
	}
	public static void main(String[] args){
		   try{   // get the collection name in indicated database
			   mongodb mdb = new mongodb();
			   test test = new test();
			   MongoClient mongo = new MongoClient("localhost", 27017);
			  
			DB db = mongo.getDB("catdemo");
			 DBCollection collection = db.getCollection("items");
			 
			/* DBCursor cursor = collection.find();
			 while(cursor.hasNext()) {
			        System.out.println(cursor.next());}*/
	//selectSingleRecordAndFieldByRecordNumber(collection);
	
			
		   }catch(Exception e){
				     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				  }
			   }
			}