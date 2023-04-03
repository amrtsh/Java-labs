package ua.lviv.iot.algo.part1.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShipManager {
     private static final List<Ship> ships = new ArrayList<>();

    public static void main(String[] args) {
        ShipManager.addShip(new CruiseShip("Carpe Diem", "Ferdinand Magellan", "Chennai", 46.3, 10.000, 0, 40, 3245, 23, 140));
        ShipManager.addShip(new CruiseShip( "Happy Hour", "Horatio Nelson", "Mariupol", 46.3, 10.000, 0, 45, 3245, 23, 134));
        ShipManager.addShip(new CargoShip("Serenity", "William Kidd", "Shenzhen", 46.3, 10.000, 456, 43, 3245, "refrigerated", 45));
        ShipManager.addShip(new CargoShip("Dreamboat", "Francis Drake", "Mangalore", 46.3, 10.000, 789, 45, 3245, "bulk", 35));
        ShipManager.addShip(new MilitaryShip("Carlisle", "James Patton", "Mariupol", 46.3, 10.000, 756, 40, 236, 35));
        ShipManager.addShip(new MilitaryShip("The Alerte", "Nathaniel Crosby", "Shenzhen", 46.3, 10.000, 789, 40, 167, 35));
        ShipManager.addShip(new FishingShip("Angelica", "Asa Eldridge", "Kochi", 46.3, 10.000, 745, 43, 43, 54));
        ShipManager.addShip(new FishingShip("Talisman", "Carl Frick", "Mariupol", 46.3, 10.000, 325, 40, 35, 59));

        ShipManager.findAllWithMaxSpeedMoreThan(34);
        ShipManager.findAllWithSameCurrentPort("Mariupol");


        for (Ship ship : ships) {
            System.out.println("Максимальна кількість людей: " + ship.getTotalPeopleCount());
            System.out.println("Час завантаження: " + ship.calculateLoadTime() + " хвилин");
            System.out.println(ship);
        }

    }
    public static void addShip(final Ship ship){
        ships.add(ship);
    }
    public static void findAllWithMaxSpeedMoreThan(int maxSpeed){
        System.out.println("Кораблі, швидкість яких більша за " + maxSpeed + ":");
        ships.stream().filter(s -> (s.getMaxSpeed() > maxSpeed)).toList().forEach(System.out::println);
    }
    public static void findAllWithSameCurrentPort(String currentPort){
        System.out.println("Кораблі, порт яких співпадає " + currentPort + ":");
        ships.stream().filter(s -> (Objects.equals(s.getCurrentPort(), currentPort))).toList().forEach(System.out::println);
    }
}

