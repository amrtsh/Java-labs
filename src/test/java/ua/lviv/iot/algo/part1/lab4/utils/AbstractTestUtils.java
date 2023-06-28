package ua.lviv.iot.algo.part1.lab4.utils;

import ua.lviv.iot.algo.part1.lab4.models.*;

import java.util.LinkedList;
import java.util.List;

public class AbstractTestUtils {
    public static List<Ship> prepareTestShips() {
        List<Ship> shipManager = new LinkedList<>();
        shipManager.add(new CruiseShip(1, "Carpe Diem", "Ferdinand Magellan",
                "Chennai", 30.3, 10.000, 0,
                40, 3245, 23, 140));
        shipManager.add(new CargoShip(3, "Serenity", "William Kidd",
                "Shenzhen", 26.3, 10.000, 456,
                43, 3245, "refrigerated", 45));
        shipManager.add(new MilitaryShip(5, "Carlisle", "James Patton",
                "Mariupol", 32.3, 10.000, 756,
                40, 236, 35));
        shipManager.add(new FishingShip(8, "Talisman", "Carl Frick",
                "Mariupol", 46.3, 10.000, 325,
                40, 35, 59));
        return shipManager;
    }
}
