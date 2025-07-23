package com.hotel.dao;

import com.hotel.model.*;
import com.hotel.util.DBConnectionUtil;
import java.sql.*;
import java.util.*;

public class HotelDAOImpl implements HotelDAO {

    public void addRoom(Room room) {
        try (Connection conn = DBConnectionUtil.getConnection()) {
            String sql = "INSERT INTO rooms VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, room.getRoomId());
            ps.setString(2, room.getType());
            ps.setDouble(3, room.getPrice());
            ps.setBoolean(4, room.isAvailable());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error adding room: " + e.getMessage());
        }
    }

    public void bookRoom(Booking booking) {
        try (Connection conn = DBConnectionUtil.getConnection()) {
            // Check availability
            String checkSql = "SELECT available FROM rooms WHERE room_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, booking.getRoomId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getBoolean("available")) {
                String insertSql = "INSERT INTO bookings (room_id, customer_name, check_in, check_out) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setInt(1, booking.getRoomId());
                insertStmt.setString(2, booking.getCustomerName());
                insertStmt.setDate(3, booking.getCheckIn());
                insertStmt.setDate(4, booking.getCheckOut());
                insertStmt.executeUpdate();

                String updateSql = "UPDATE rooms SET available = false WHERE room_id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setInt(1, booking.getRoomId());
                updateStmt.executeUpdate();

                System.out.println("✅ Room booked successfully!");
            } else {
                System.out.println("❌ Room is not available.");
            }

        } catch (Exception e) {
            System.out.println("Error booking room: " + e.getMessage());
        }
    }

    public List<Room> getAvailableRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Connection conn = DBConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM rooms WHERE available = true";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rooms.add(new Room(
                        rs.getInt("room_id"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getBoolean("available")));
            }
        } catch (Exception e) {
            System.out.println("Error fetching available rooms: " + e.getMessage());
        }
        return rooms;
    }
}
