package com.hotel.dao;

import com.hotel.model.*;
import java.util.*;

public interface HotelDAO {
    void addRoom(Room room);
    void bookRoom(Booking booking);
    List<Room> getAvailableRooms();
}
