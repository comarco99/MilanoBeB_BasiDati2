package model;

import java.util.ArrayList;

public class Listing {
    private int listingId;
    private String name;
    private String hostName;
    private String neighbourhood;
    private Double latitude;
    private Double longitude;
    private String roomType;
    private int numberOfReviews;
    //private ArrayList<Calendar> calendarList;
    private Double price;
    private ArrayList<Review> reviews;

    public Listing(int listingId, String name, String hostName, String neighbourhood, Double latitude, Double longitude, String roomType, int numberOfReviews, /*ArrayList<Calendar> calendarList,*/Double price, ArrayList<Review> reviews) {
        this.listingId = listingId;
        this.name = name;
        this.hostName = hostName;
        this.neighbourhood = neighbourhood;
        this.latitude = latitude;
        this.longitude = longitude;
        this.roomType = roomType;
        this.numberOfReviews = numberOfReviews;
        //this.calendarList = calendarList;
        this.price=price;
        this.reviews = reviews;
    }

    public Listing() {
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

   /* public ArrayList<Calendar> getCalendarList() {
        return calendarList;
    }*/

 /*   public void setCalendarList(ArrayList<Calendar> calendarList) {
        this.calendarList = calendarList;
    }*/

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

}
