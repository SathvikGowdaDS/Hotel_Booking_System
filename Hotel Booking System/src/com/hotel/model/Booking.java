package com.hotel.model;

import java.sql.Date;

public class Booking {
    private int roomId;
    private String customerName;
    private Date checkIn;
    private Date checkOut;

    public Booking(int roomId, String customerName, Date checkIn, Date checkOut) {
        this.roomId = roomId;
        this.customerName = customerName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

 // Getters and Setters
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
}
