package com.hotel.app;

import com.hotel.dao.*;
import com.hotel.model.*;

import java.sql.Date;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelDAO dao = new HotelDAOImpl();

        while (true) {
            System.out.println("\n==== Hotel Booking System ====");
            System.out.println("1. Add Room");
            System.out.println("2. View Available Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Room ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Type (Single/Double): ");
                    String type = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    dao.addRoom(new Room(id, type, price, true));
                    System.out.println("✅ Room added.");
                    break;

                case 2:
                    List<Room> rooms = dao.getAvailableRooms();
                    System.out.println("Available Rooms:");
                    for (Room r : rooms) {
                        System.out.println("ID: " + r.getRoomId() + ", Type: " + r.getType() + ", Price: " + r.getPrice());
                    }
                    break;

                case 3:
                    System.out.print("Room ID to book: ");
                    int rid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Check-In (yyyy-mm-dd): ");
                    Date in = Date.valueOf(sc.nextLine());
                    System.out.print("Check-Out (yyyy-mm-dd): ");
                    Date out = Date.valueOf(sc.nextLine());

                    dao.bookRoom(new Booking(rid, name, in, out));
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
