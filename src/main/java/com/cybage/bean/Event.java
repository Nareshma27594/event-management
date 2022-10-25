package com.cybage.bean;

public class Event {
int event_id;
public String getName() {
	return name;
}
public Event(int event_id, String name, String venue, int price, int organizer_id, String category, String date) {
	super();
	this.event_id = event_id;
	this.name = name;
	this.venue = venue;
	this.price = price;
	this.organizer_id = organizer_id;
	this.category = category;
	this.date = date;
}
public void setName(String name) {
	this.name = name;
}
public String getVenue() {
	return venue;
}
public void setVenue(String venue) {
	this.venue = venue;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getOrganizer_id() {
	return organizer_id;
}
public void setOrganizer_id(int organizer_id) {
	this.organizer_id = organizer_id;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getEvent_id() {
	return event_id;
}
String name;
String venue;
int price;
int organizer_id;
String category;
String date;
}
