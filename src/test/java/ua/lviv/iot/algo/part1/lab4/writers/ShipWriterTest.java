package ua.lviv.iot.algo.part1.lab4.writers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.algo.part1.lab4.utils.AbstractTestUtils;
import ua.lviv.iot.algo.part1.lab4.models.Ship;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ua.lviv.iot.algo.part1.lab4.utils.AbstractTestUtils.prepareTestShips;

class ShipWriterTest {
    private static final String EXPECTED_SORTED_FILE =
            "C:\\Users\\user\\IdeaProjects\\lab4\\src\\main\\resources\\expected-sorted-ships.csv";

    ShipWriter writer;
    List<Ship> ships;

    @BeforeEach
    public void init() {
            writer = new ShipWriter();
            ships = AbstractTestUtils.prepareTestShips();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(ShipWriter.SORTED_SHIPS_FILE));
    }

    @Test
    public void testEmptySortedWrite() {
        writer.sortedWriteToFile(null);
        File result = new File(ShipWriter.SORTED_SHIPS_FILE);
        assertFalse(result.exists());
    }

    @Test
    public void testSortedWriteToFile() throws IOException {
        writer.sortedWriteToFile(prepareTestShips());

        Path expected = new File(EXPECTED_SORTED_FILE).toPath();
        Path actual = new File(ShipWriter.SORTED_SHIPS_FILE).toPath();

        assertEquals(-0L, Files.mismatch(expected, actual));
    }

    @Test
    public void testSortedRewriteToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter(ShipWriter.SORTED_SHIPS_FILE)) {
            fileWriter.write("rewriting (sorted)...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        testSortedWriteToFile();
    }
}