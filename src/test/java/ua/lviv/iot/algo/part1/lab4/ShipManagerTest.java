package ua.lviv.iot.algo.part1.lab4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ShipManagerTest {

    private List<Ship> ships;

    private final ArrayList<Ship> shipsWithMaxSpeedMoreThan = new ArrayList<>(Arrays.asList(
            new CruiseShip(2, "Happy Hour", "Horatio Nelson", "Mariupol", 76.3, 10.000, 0, 45, 3245, 23, 134),
            new CargoShip(4, "Dreamboat", "Francis Drake", "Mangalore", 36.3, 10.000, 789, 45, 3245, "bulk", 35),
            new MilitaryShip(6, "The Alerte", "Nathaniel Crosby", "Shenzhen", 56.3, 10.000, 789, 40, 167, 35),
            new FishingShip(8, "Talisman", "Carl Frick", "Mariupol", 46.3, 10.000, 325, 40, 35, 59)));

    private final List<Ship> shipsFindAllWithSameCurrentPort = Arrays.asList(
            new CruiseShip(2, "Happy Hour", "Horatio Nelson", "Mariupol", 76.3, 10.000, 0, 45, 3245, 23, 134),
            new MilitaryShip(5, "Carlisle", "James Patton", "Mariupol", 32.3, 10.000, 756, 40, 236, 35),
            new FishingShip(8, "Talisman", "Carl Frick", "Mariupol", 46.3, 10.000, 325, 40, 35, 59));

    @BeforeEach
    public void init() {
        ships = Arrays.asList(
                new CruiseShip(1, "Carpe Diem", "Ferdinand Magellan", "Chennai", 30.3, 10.000, 0, 40, 3245, 23, 140),
                new CruiseShip(2, "Happy Hour", "Horatio Nelson", "Mariupol", 76.3, 10.000, 0, 45, 3245, 23, 134),
                new CargoShip(3, "Serenity", "William Kidd", "Shenzhen", 26.3, 10.000, 456, 43, 3245, "refrigerated", 45),
                new CargoShip(4, "Dreamboat", "Francis Drake", "Mangalore", 36.3, 10.000, 789, 45, 3245, "bulk", 35),
                new MilitaryShip(5, "Carlisle", "James Patton", "Mariupol", 32.3, 10.000, 756, 40, 236, 35),
                new MilitaryShip(6, "The Alerte", "Nathaniel Crosby", "Shenzhen", 56.3, 10.000, 789, 40, 167, 35),
                new FishingShip(7, "Angelica", "Asa Eldridge", "Kochi", 28.3, 10.000, 745, 43, 43, 54),
                new FishingShip(8, "Talisman", "Carl Frick", "Mariupol", 46.3, 10.000, 325, 40, 35, 59));
    }

    @Test
    public void testFindAllWithMaxSpeedMoreThan() {
        List<Ship> result = ShipManager.findAllWithMaxSpeedMoreThan(ships, 34);
        Assertions.assertEquals(shipsWithMaxSpeedMoreThan.size(), result.size());
        for (int i = 0; i < shipsWithMaxSpeedMoreThan.size(); i++) {
            Assertions.assertEquals(shipsWithMaxSpeedMoreThan.get(i), result.get(i));
        }
    }

    @Test
    public void testFindAllWithSameCurrentPort() {
        List<Ship> result = ShipManager.findAllWithSameCurrentPort(ships, "Mariupol");
        Assertions.assertEquals(shipsFindAllWithSameCurrentPort.size(), result.size());
        for (int i = 0; i < shipsFindAllWithSameCurrentPort.size(); i++) {
            Assertions.assertEquals(shipsFindAllWithSameCurrentPort.get(i), result.get(i));
        }
    }
}
