package ua.lviv.iot.algo.part1.lab4.writers;

import ua.lviv.iot.algo.part1.lab4.models.Ship;

import java.io.File;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

import static java.util.stream.Collectors.groupingBy;

public class ShipWriter {
    public static final String SORTED_SHIPS_FILE =
            "C:\\Users\\user\\IdeaProjects\\lab4\\src\\main\\resources\\sorted-ships.csv";
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
        try (FileWriter writer = new FileWriter(SORTED_SHIPS_FILE)) {
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
