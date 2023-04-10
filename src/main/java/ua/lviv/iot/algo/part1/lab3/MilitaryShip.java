package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public class MilitaryShip extends Ship {
    private int minutes = 60;
    private int tonn = 20;
    private int military;
    private int crewCount;

    public MilitaryShip(final String nameOfShip, final String captainName, final String currentPort, final double maxSpeed, final double maxCapacity,
                        final double currentLoad, final double currentSpeed, final int military, final int crewCount) {
        super(nameOfShip, captainName, currentPort, maxSpeed, maxCapacity, currentLoad, currentSpeed);
        this.military = military;
        this.crewCount = crewCount;
    }

    public MilitaryShip(final double id, final String nameOfShip, final String captainName, final String currentPort, final double maxSpeed, final double maxCapacity,
                        final double currentLoad, final double currentSpeed, final int military, final int crewCount) {
        super(id, nameOfShip, captainName, currentPort, maxSpeed, maxCapacity, currentLoad, currentSpeed);
        this.military = military;
        this.crewCount = crewCount;
    }

    @Override
    public int getTotalPeopleCount() {
        return military + crewCount;
    }

    @Override
    public double calculateLoadTime() {
        return currentLoad * minutes / tonn;
    }
}
