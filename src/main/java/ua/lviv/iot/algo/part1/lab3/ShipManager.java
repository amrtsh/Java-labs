package ua.lviv.iot.algo.part1.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShipManager {
    private static final List<Ship> ships = new ArrayList<>();

    public static void main(String[] args) {
        ShipManager.addShip(new CruiseShip("Carpe Diem", "Ferdinand Magellan", "Chennai", 46.3, 10.000, 0, 40, 3245, 23, 140));
        ShipManager.addShip(new CruiseShip(10, "Happy Hour", "Horatio Nelson", "Mariupol", 46.3, 10.000, 0, 45, 3245, 23, 134));
        ShipManager.addShip(new CargoShip(11, "Serenity", "William Kidd", "Shenzhen", 46.3, 10.000, 456, 43, 3245, "refrigerated", 45));
        ShipManager.addShip(new CargoShip(12, "Dreamboat", "Francis Drake", "Mangalore", 46.3, 10.000, 789, 45, 3245, "bulk", 35));
        ShipManager.addShip(new MilitaryShip(13, "Carlisle", "James Patton", "Mariupol", 46.3, 10.000, 756, 40, 236, 35));
        ShipManager.addShip(new MilitaryShip(14, "The Alerte", "Nathaniel Crosby", "Shenzhen", 46.3, 10.000, 789, 40, 167, 35));
        ShipManager.addShip(new FishingShip(15, "Angelica", "Asa Eldridge", "Kochi", 46.3, 10.000, 745, 43, 43, 54));
        ShipManager.addShip(new FishingShip(16, "Talisman", "Carl Frick", "Mariupol", 46.3, 10.000, 325, 40, 35, 59));

        printAllWithMaxSpeedMoreThan(ships, 34);
        printAllWithSameCurrentPort(ships, "Mariupol");


        for (Ship ship : ships) {
            System.out.println("Максимальна кількість людей: " + ship.getTotalPeopleCount());
            System.out.println("Час завантаження: " + ship.calculateLoadTime() + " хвилин");
            System.out.println(ship);
        }

    }

    public static void addShip(final Ship ship) {
        ships.add(ship);
    }

    public static List<Ship> findAllWithMaxSpeedMoreThan(List<Ship> shipsList, int maxSpeed) {
        return shipsList.stream().filter(s -> (s.getMaxSpeed() > maxSpeed)).collect(Collectors.toList());
    }

    public static List<Ship> findAllWithSameCurrentPort(List<Ship> shipsList, String currentPort) {
        return shipsList.stream().filter(s -> (Objects.equals(s.getCurrentPort(), currentPort))).collect(Collectors.toList());
    }

    public static void printAllWithMaxSpeedMoreThan(List<Ship> shipsList, int maxSpeed) {
        System.out.println("Кораблі, швидкість яких більша за " + maxSpeed + ":");
        findAllWithMaxSpeedMoreThan(shipsList, maxSpeed).forEach(System.out::println);
    }

    public static void printAllWithSameCurrentPort(List<Ship> shipsList, String currentPort) {
        System.out.println("Кораблі, порт яких співпадає " + currentPort + ":");
        findAllWithSameCurrentPort(shipsList, currentPort).forEach(System.out::println);
    }
}
