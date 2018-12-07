/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zing.statcollect.common;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.vng.zing.statcollect.enities.StatsPoint;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author hagyhang
 */
public class DBConnect {
//	private static MongoClient mongoClient = new MongoClient( "localhost" , 27017);
//	private static MongoDatabase database = mongoClient.getDatabase("collectorDB");
//	private static MongoCollection<Document> secCollection = database.getCollection("secondPoints");
//	private static MongoCollection<Document> minCollection = database.getCollection("minutePoints");
//	private static MongoCollection<Document> hourCollection = database.getCollection("hourPoints");
	private static int DELAY = 5;
	private static String USER_AGENT = "Mozilla/5.0";
	
	
//	public static void pushSecStatsPoints(StatsPoint point, String name){
//		Bson filter = new Document("name", name);
//		long count = secCollection.count(filter);
//		if (count < 1) {
//			secCollection.insertOne((Document) filter);
//		}
//		Bson value = new Document(point.toMap());
//		Bson updateOperationDocument = new Document("$push", new Document("points", value));
//		secCollection.findOneAndUpdate(filter, updateOperationDocument);
//	}
	
//	public static List<StatsPoint> getStatsPoints (int max, String name){
//		List<StatsPoint> ret = new ArrayList<>();
//		long startTime = System.currentTimeMillis()/1000 - max - DELAY;
//		startTime *= 1000;
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(startTime);
//		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + "h " + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
//		
//		Document query = new Document("name", name);
//		Document limit = new Document("points", new Document("$slice", -(max + DELAY)));
//		Document rawRet = secCollection.find(query).projection(limit).first();
////		Document rawRet = secCollection.find(query).projection(Projections.slice("points", max)).first();
//		if (rawRet == null){
//			return ret;
//		}
//		int count = 0;
//		List<Document> arr = (List<Document>) rawRet.get("points");
//		for(Document doc : arr){
//			StatsPoint point = new StatsPoint(doc);
////			System.out.println("count: "+ count + " - time: " +(point.timeEnd - current));
//			if ((point.timestamp - startTime) < 0){
//				continue;
//			}
//			ret.add(point);
//			if (++count >= max){
//				break;
//			}
////			System.out.println(new BaseStatsPoint(point).toJSONString());
//		}
//		return ret;
//	}
//	
//	public static List<StatsPoint> getStatsPointsV2 (int max, String name, int interval){
//		List<StatsPoint> ret = new ArrayList<>();
//		long current = System.currentTimeMillis()/1000 - DELAY;
//		
//		long startTime = current - max - current % interval;
//		startTime *= 1000;
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(startTime);
//		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + "h " + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
//		
//		Document query = new Document("name", name);
//		Document limit = new Document("points", new Document("$slice", -(max + interval + DELAY + 5)));
//		Document rawRet = secCollection.find(query).projection(limit).first();
//		if (rawRet == null){
//			return ret;
//		}
//		int count = 0;
//		List<Document> arr = (List<Document>) rawRet.get("points");
//		for(Document doc : arr){
//
//			StatsPoint point = new StatsPoint(doc);
//			if (point.timestamp - startTime < 0){
////				System.out.println(i + " timestamp: " + point.timestamp + " - " + startTime);
//				continue;
//			}
//			ret.add(point);
//			if (++count >= max){
//				break;
//			}
//		}
////		System.out.println("count: " + count);
//		return ret;
//	}
	
	
	public static String sendGet(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		return response.toString();
	}
	
	// HTTP POST request
	public static String sendPost(String url, String data) {
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			
			byte[] out = data.getBytes(StandardCharsets.UTF_8);
			int length = out.length;
			con.setDoOutput(true);
			con.setFixedLengthStreamingMode(length);
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			con.connect();
			try(OutputStream os = con.getOutputStream()) {
				os.write(out);
			}
			int responseCode = con.getResponseCode();
			if (responseCode > 299 && responseCode < 200){
				return null;
			}
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			return response.toString();
		} catch (IOException ex) {
		}
		return null;
	}

	
	public static void main(String[] args) {
//		sendPost(BASEURL, BASEURL);
		
	}
}
