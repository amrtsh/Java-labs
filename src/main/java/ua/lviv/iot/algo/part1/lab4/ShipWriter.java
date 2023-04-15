package ua.lviv.iot.algo.part1.lab4;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

import static java.util.stream.Collectors.groupingBy;

public class ShipWriter {
    public static final String SHIPS_FILE =
            "./ships.csv";
    public static final String SORTED_SHIPS_FILE =
            "./sorted-ships.csv";
    public void writeToFile(List<Ship> ships) {
        if (ships == null || ships.isEmpty()) {
            return;
        }

        try (FileWriter writer = new FileWriter("./ships.csv")) {
            for (var ship : ships) {
                writer.write(ship.getClass().getSimpleName() + "\n");
                writer.write(ship.getHeaders());
                writer.write(" \r\n");
                writer.write(ship.toCSV());
                writer.write(" \r\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sortedWriteToFile(List<Ship> ships) {
        if (ships == null || ships.isEmpty()) {
            return;
        }

        List<Ship> sortedShipList = ships.stream()
                .collect(groupingBy(w -> w.getClass().getSimpleName()))
                .entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .toList();
        String lastClassName = null;
        try (FileWriter writer = new FileWriter("./sorted-ships.csv")) {
            for (var ship : sortedShipList) {
                String className = ship.getClass().getSimpleName();
                if (!className.equals(lastClassName)) {
                    writer.write(className + "\n");
                    writer.write(ship.getHeaders() + "\n");
                    lastClassName = className;
                }
                writer.write(ship.toCSV() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
