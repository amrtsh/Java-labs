package ua.lviv.iot.algo.part1.lab4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public class CruiseShip extends Ship {
    final public double minutes = 60.0;
    final public int minForEach = 5;
    public int passangersCount;
    public int crewCount;
    public int numberOfSupportStaff;

    public CruiseShip(final String nameOfShip, final String captainName,
                      final String currentPort, final double maxSpeed,
                      final double maxCapacity, final double currentLoad,
                      final double currentSpeed, final int passangersCount,
                      final int crewCount, final int numberOfSupportStaff) {
        super(nameOfShip, captainName, currentPort,
                maxSpeed, maxCapacity,
                currentLoad, currentSpeed);
        this.passangersCount = passangersCount;
        this.crewCount = crewCount;
        this.numberOfSupportStaff = numberOfSupportStaff;
    }

    public CruiseShip(final double id, final String nameOfShip,
                      final String captainName, final String currentPort,
                      final double maxSpeed, final double maxCapacity,
                      final double currentLoad, final double currentSpeed,
                      final int passangersCount,
                      final int crewCount, final int numberOfSupportStaff) {
        super(id, nameOfShip, captainName, currentPort,
                maxSpeed, maxCapacity,
                currentLoad, currentSpeed);
        this.passangersCount = passangersCount;
        this.crewCount = crewCount;
        this.numberOfSupportStaff = numberOfSupportStaff;
    }

    @Override
    public int getTotalPeopleCount() {
        return passangersCount + crewCount + numberOfSupportStaff;
    }

    @Override
    public double calculateLoadTime() {
        return getTotalPeopleCount() * minForEach / minutes; }
    @Override
    public String getHeaders() {
        return super.getHeaders() + ",passangersCount,crewCount,numberOfSupportStaff";
    }
    @Override
    public String toCSV() {
        return super.toCSV() + ","
                + passangersCount + ", "
                + crewCount + ", "
                + numberOfSupportStaff;
    }
}
