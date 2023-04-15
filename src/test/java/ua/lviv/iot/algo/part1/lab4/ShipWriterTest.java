package ua.lviv.iot.algo.part1.lab4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ShipWriterTest {

    private static final String EXPECTED_SHIPS_FILE =
            "./ships.csv";
    private static final String EXPECTED_SORTED_FILE =
            "./sorted-ships.csv";

    ShipWriter writer;
    ShipManager ships;

    @BeforeEach
    public void init() {
            writer = new ShipWriter();
            ships = new ShipManager();
            for (int i = 0; i < 2; i++) {
                ShipManager.addShip(new CruiseShip(1, "Carpe Diem", "Ferdinand Magellan",
                        "Chennai", 30.3, 10.000, 0,
                        40, 3245, 23, 140));
                ShipManager.addShip(new CargoShip(3, "Serenity", "William Kidd",
                        "Shenzhen", 26.3, 10.000, 456,
                        43, 3245, "refrigerated", 45));
                ShipManager.addShip(new MilitaryShip(5, "Carlisle", "James Patton",
                        "Mariupol", 32.3, 10.000, 756,
                        40, 236, 35));
                ShipManager.addShip(new FishingShip(8, "Talisman", "Carl Frick",
                        "Mariupol", 46.3, 10.000, 325,
                        40, 35, 59));
            }
        }

    @Test
    public void testEmptyWrite() {
        writer.writeToFile(null);
        File result = new File(ShipWriter.SHIPS_FILE);
        assertFalse(result.exists());
    }
    @Test
    public void testEmptySortedWrite() {
        writer.sortedWriteToFile(null);
        File result = new File(ShipWriter.SORTED_SHIPS_FILE);
        assertFalse(result.exists());
    }

    @Test
    public void testWriteToFile() throws IOException {
        writer.writeToFile(ShipManager.ships);

        Path expected = new File(EXPECTED_SHIPS_FILE).toPath();
        Path actual = new File(ShipWriter.SHIPS_FILE).toPath();

        assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testSortedWriteToFile() throws IOException {
        writer.sortedWriteToFile(ShipManager.ships);

        Path expected = new File(EXPECTED_SORTED_FILE).toPath();
        Path actual = new File(ShipWriter.SORTED_SHIPS_FILE).toPath();

        assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(ShipWriter.SHIPS_FILE));
        Files.deleteIfExists(Path.of(ShipWriter.SORTED_SHIPS_FILE));
    }
}
