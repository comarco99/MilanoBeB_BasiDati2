package model;
import com.mongodb.*;
import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import jdk.nashorn.internal.parser.JSONParser;
import org.bson.conversions.Bson;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.client.model.geojson.Position;
import static com.mongodb.client.model.Filters.near;
import static com.mongodb.client.model.Filters.geoWithin;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static com.mongodb.client.model.Projections.excludeId;
import com.mongodb.client.model.Updates;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import netscape.javascript.JSObject;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;

public class DBConnectionCRUD {
    //motodo per costruire oggetto di tipo listing a partire da un document
    public static Listing listingFromDocument(Document c){
        String json = c.toJson(JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).build());
        //System.out.println("FUNZIONE\n"+json);
        final JSONObject obj = new JSONObject(json);
        int listingId = obj.getInt("listing_id");
        String name = (String) obj.get("name");
        String hostName = (String) obj.get("host_name");
        String neighbourhood = (String) obj.get("neighbourhood");
        Double latitude = obj.getDouble("latitude");
        Double longitude = obj.getDouble("longitude");
        String roomType = (String) obj.get("room_type");;
        int numberOfReviews= obj.getInt("number_of_reviews");
        Double price = obj.getDouble("price");
        JSONArray review = obj.getJSONArray("reviews");
        ArrayList<Review> reviewList = new ArrayList<Review>();
        int m = review.length();
        for (int i = 0; i < m; ++i) {
            JSONObject singleReview = review.getJSONObject(i);
            String reviewDate = singleReview.getString("review_date");
            String reviewerName = singleReview.getString("reviewer_name");
            String comment = singleReview.getString("comments");
            Review currentReview= new Review(reviewDate,reviewerName,comment);
            reviewList.add(currentReview);
        }
        Listing listing= new Listing(listingId,name,hostName,neighbourhood,latitude,longitude,roomType,numberOfReviews, price, reviewList);

        return listing;
    }

    //metodo per creare connessione al database Milano
    //restituisce un db
    public static MongoCollection<Document> connection(String col){
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
        CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoDatabase db = mongoClient.getDatabase("Milano").withCodecRegistry(pojoCodecRegistry);

        MongoCollection<Document> collection = db.getCollection(col);
        //indicizzo in ordine crescente di altri elementi
        collection.createIndex(Indexes.ascending("listing_id"));
        collection.createIndex(Indexes.ascending("neighbourhood"));
        collection.createIndex(Indexes.ascending("number_or_reviews"));
        collection.createIndex(Indexes.ascending("price"));
        collection.createIndex(Indexes.ascending("room_type"));
        return collection;
    }

    //metodo per ottenere tutti i document trasformati in listing in una collection
    public static ArrayList<Listing> retrieveAllDocument(){
        MongoCollection<Document> collection = connection("listing");
        ArrayList<Document> documents= new ArrayList<Document>();
        ArrayList<Listing> listings= new ArrayList<Listing>();

        FindIterable<Document> iterDoc = collection.find();
        int i=1;
        Iterator it =iterDoc.iterator();
        while(it.hasNext()){
            listings.add(listingFromDocument((Document) it.next()));
            if(i==5000){break;}
            i++;
        }

        return listings;
    }

    //metodo per inserire un nuovo AirB&B (tipo Listing) nella collection listing
    public static void insertListing(Listing listing){
        MongoCollection<Document> collection = connection("listing");
        Document d = new Document("listing_id",listing.getListingId())
                .append("name", listing.getName())
                .append("host_name", listing.getHostName())
                .append("neighbourhood", listing.getNeighbourhood())
                .append("latitude", listing.getLatitude())
                .append("longitude", listing.getLongitude())
                .append("room_type", listing.getRoomType())
                .append("number_of_reviews", listing.getNumberOfReviews())
                .append("price", listing.getPrice())
                .append("reviews", new JSONArray());

        collection.insertOne(d);
    }

    //metodo per eliminare un AirB&B dalla collection listing dato il suo name
    public static void deleteListing(String nome){
        MongoCollection<Document> collection = connection("listing");
        collection.deleteOne(Filters.eq("name", nome));
    }

    //metodo per aggiornare un AirB&B
    public static void update(int listingId,String nome, String host, String neigh, Double lat, Double lon, String room, Double price){
        MongoCollection<Document> collection = connection("listing");

        collection.updateMany(
                Filters.eq("listing_id", listingId),
                Updates.combine(
                        Updates.set("name", nome),
                        Updates.set("host_name", host),
                        Updates.set("neighbourhood", neigh),
                        Updates.set("latitude", lat),
                        Updates.set("longitude", lon),
                        Updates.set("room_type", room),
                        Updates.set("number_of_reviews", 0),
                        Updates.set("price", price)));
    }

    //metodo per avere un AirB&B con un dato id
    public static Listing retrieveById(int id){
        MongoCollection<Document> collection = connection("listing");
        Document airById = new Document();

        Bson condition= new Document("$eq",id);
        Bson filter= new Document("listing_id",condition);
        Document el = new Document();
        for(Document document :  collection.find(filter)){
            el=document;
        }
        return listingFromDocument(el);
    }

    //metodo per avere tutti gli AirB&B in un dato neighbourhood
    public static ArrayList<Listing> retrieveByNeighbourhood(String neighbour){
        MongoCollection<Document> collection = connection("listing");
        ArrayList<Listing> airInNeighbour = new ArrayList<Listing>();

        Bson condition= new Document("$eq",neighbour);
        Bson filter= new Document("neighbourhood",condition);
        for(Document document :  collection.find(filter)){
            airInNeighbour.add(listingFromDocument(document));
        }

        return airInNeighbour;
    }

    //metodo per avere tutti gli AirB&B con un numero di recensioni(reviews) compreso
    public static ArrayList<Listing> retrieveByNumbersOfReviews(int min, int max){
        ArrayList<Listing> listingByRev = new ArrayList<Listing>();
        MongoCollection<Document> collection = connection("listing");

        BasicDBObject query = new BasicDBObject();
        query.put("number_of_reviews", new BasicDBObject("$gte", min).append("$lte", max));

        for (Document doc : collection.find(query)) {
            listingByRev.add(listingFromDocument(doc));
        }
        return listingByRev;
    }

    //metodo per avere tutti gli AirB&B compreso tra due prezzi
    public static ArrayList<Listing> retrieveByPrice(int min, int max){
        ArrayList<Listing> listingByPrice = new ArrayList<Listing>();
        MongoCollection<Document> collection = connection("listing");

        BasicDBObject query = new BasicDBObject();
        query.put("price", new BasicDBObject("$gte", min).append("$lte", max));

        for (Document doc : collection.find(query)) {
            listingByPrice.add(listingFromDocument(doc));
        }
        return listingByPrice;
    }

    //metodo per avere gli AirB&B con determinato tipo di camera
    public static ArrayList<Listing> retrieveByRoomType(String type){
        ArrayList<Listing> listingByRoom = new ArrayList<Listing>();
        MongoCollection<Document> collection = connection("listing");

        BasicDBObject query = new BasicDBObject();
        query.put("room_type", new BasicDBObject("$eq", type));

        for (Document doc : collection.find(query)) {
            listingByRoom.add(listingFromDocument(doc));
        }

        return listingByRoom;
    }

    //metodo per avere tutte le recensioni di un dato AirB&B
    public static ArrayList<Review> retrieveReviews(int id){
        MongoCollection<Document> collection = connection("listing");
        ArrayList<Review> revs = new ArrayList<Review>();

        BasicDBObject query = new BasicDBObject();
        query.put("listing_id", new BasicDBObject("$eq", id));

        Document doc = collection.find(query).first();
        Listing l = listingFromDocument(doc);

        return l.getReviews();
    }

    //i 15 b&b più vicini al Duomo
    public static ArrayList<Listing> retrieveNearDuomo(String place){
        ArrayList<Listing> nearDuomo = new ArrayList<>();
        MongoCollection<Document> collection = connection("locations");
        collection.createIndex(Indexes.geo2dsphere("location"));

        Document query = new Document();
        if(place.equals("duomo")) {
            query = new Document("location",
                    new Document("$near",
                            new Document("$geometry",
                                    new Document("type", "Point").append("coordinates", Arrays.asList(9.191383,45.464211)))));
        }
        if(place.equals("citylife")){
            query = new Document("location",
                    new Document("$near",
                            new Document("$geometry",
                                    new Document("type", "Point").append("coordinates", Arrays.asList(9.155214, 45.4741)))));
        }
        if(place.equals("navigli")){
            query = new Document("location",
                    new Document("$near",
                            new Document("$geometry",
                                    new Document("type", "Point").append("coordinates", Arrays.asList(9.16667, 45.45)))));
        }
        if(place.equals("sforzesco")){
            query = new Document("location",
                    new Document("$near",
                            new Document("$geometry",
                                    new Document("type", "Point").append("coordinates", Arrays.asList(8.8587, 45.31706)))));
        }
        for (Document c : collection.find(query).limit(15)){
            String json = c.toJson(JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).build());
            JSONObject obj = new JSONObject(json);
            Listing currentId= retrieveById(obj.getInt("id"));
            nearDuomo.add(currentId);
        }

        return nearDuomo;
    }

    public static ArrayList<Listing> retrieveByAllFilters(String zona, int minR, int maxR, int minP, int maxP, String room){
        ArrayList<Listing> listingByAll = new ArrayList<Listing>();
        MongoCollection<Document> collection = connection("listing");

        BasicDBObject query = new BasicDBObject();
        query.put("neighbourhood", new BasicDBObject("$eq",zona));
        query.put("number_of_reviews", new BasicDBObject("$gte", minR).append("$lte", maxR));
        query.put("price", new BasicDBObject("$gte", minP).append("$lte", maxP));
        query.put("room_type", new BasicDBObject("$eq", room));

        for (Document doc : collection.find(query)) {
            listingByAll.add(listingFromDocument(doc));
        }

        return listingByAll;
    }
}
