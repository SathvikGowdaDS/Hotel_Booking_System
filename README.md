✅ Hotel Booking System – Project Description
The Hotel Booking System is a console-based Java application that uses JDBC to interact with a MySQL database for managing hotel rooms and customer bookings. It simulates a real-world hotel environment where rooms can be added, viewed, and booked by customers.

🔧 Key Features
1.Add New Rooms
📌 Admins can add rooms with details such as:
➡️ Room ID
➡️ Type (Single, Double, Suite)
➡️ Price
➡️ Availability

2.Book a Room
📌 Users can book an available room by providing:
➡️ Room ID
➡️ Customer Name
➡️ Check-in and Check-out Dates
➡️ Once booked, the room is marked as unavailable.

3.List Available Rooms
📌 Displays all rooms that are currently available for booking.

4.Database Integration
📌 Data is stored persistently in a MySQL database using JDBC.
📌 SQL INSERT, SELECT, and UPDATE statements are used to manage records.

🧩 Tables in MySQL
🗃️ rooms: stores room details (room_id, type, price, available).
🗃️ bookings: stores booking details (booking_id, room_id, customer_name, check_in, check_out).
