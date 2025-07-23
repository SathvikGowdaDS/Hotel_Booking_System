package com.hotel.model;

public class Room {
    private int roomId;
    private String type;
    private double price;
    private boolean available;

    public Room(int roomId, String type, double price, boolean available) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.available = available;
    }
    

    // Getters and Setters
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}    
}
