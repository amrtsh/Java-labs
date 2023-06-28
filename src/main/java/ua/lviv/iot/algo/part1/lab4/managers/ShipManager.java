package ua.lviv.iot.algo.part1.lab4.managers;


import ua.lviv.iot.algo.part1.lab4.models.*;
import ua.lviv.iot.algo.part1.lab4.writers.ShipWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

 public class ShipManager {
     public static List<Ship> ships = new ArrayList<>();

     public static void addShip(final Ship ship) {
         ships.add(ship);
     }

     public static List<Ship> findAllWithMaxSpeedMoreThan(final List<Ship> shipsList, final int maxSpeed) {
         return shipsList.stream()
                 .filter(s -> (s.getMaxSpeed() > maxSpeed))
                 .collect(Collectors.toList());
     }

     public static List<Ship> findAllWithSameCurrentPort(final List<Ship> shipsList, final String currentPort) {
         return shipsList.stream()
                 .filter(s -> (Objects.equals(s.getCurrentPort(), currentPort)))
                 .collect(Collectors.toList());
     }

     public static void printAllWithMaxSpeedMoreThan(final List<Ship> shipsList, final int maxSpeed) {
         System.out.println("Кораблі, швидкість яких більша за " + maxSpeed + ":");
         findAllWithMaxSpeedMoreThan(shipsList, maxSpeed).forEach(System.out::println);
     }

     public static void printAllWithSameCurrentPort(final List<Ship> shipsList, final String currentPort) {
         System.out.println("Кораблі, порт яких співпадає " + currentPort + ":");
         findAllWithSameCurrentPort(shipsList, currentPort).forEach(System.out::println);
     }

     public static void main(String[] args) {
         ships = Arrays.asList(
                 new CruiseShip(1, "Carpe Diem", "Ferdinand Magellan", "Chennai", 30.3, 10.000, 0, 40, 3245, 23, 140),
                 new CruiseShip(2, "Happy Hour", "Horatio Nelson", "Mariupol", 76.3, 10.000, 0, 45, 3245, 23, 134),
                 new CargoShip(3, "Serenity", "William Kidd", "Shenzhen", 26.3, 10.000, 456, 43, 3245, "refrigerated", 45),
                 new CargoShip(4, "Dreamboat", "Francis Drake", "Mangalore", 36.3, 10.000, 789, 45, 3245, "bulk", 35),
                 new MilitaryShip(5, "Carlisle", "James Patton", "Mariupol", 32.3, 10.000, 756, 40, 236, 35),
                 new MilitaryShip(6, "The Alerte", "Nathaniel Crosby", "Shenzhen", 56.3, 10.000, 789, 40, 167, 35),
                 new FishingShip(7, "Angelica", "Asa Eldridge", "Kochi", 28.3, 10.000, 745, 43, 43, 54),
                 new FishingShip(8, "Talisman", "Carl Frick", "Mariupol", 46.3, 10.000, 325, 40, 35, 59));
        ShipWriter shipWriter = new ShipWriter();
        shipWriter.sortedWriteToFile(ships);
     }
 }
