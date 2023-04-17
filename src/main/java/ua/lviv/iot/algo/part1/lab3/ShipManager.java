package ua.lviv.iot.algo.part1.lab3;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

 public class ShipManager {
    private static final List<Ship> SHIPS = new ArrayList<>();

    private static void addShip(final Ship ship) {
        SHIPS.add(ship);
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
}
