package ua.lviv.iot.algo.part1.lab4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public  class FishingShip extends Ship {
    final public int minutes = 60;
    final public int tonn = 20;
    public int fisherman;
    public int crewCount;
    public FishingShip(final String nameOfShip, final String captainName,
                       final String currentPort, final double maxSpeed,
                       final double maxCapacity, final double currentLoad,
                       final double currentSpeed, final int crewCount,
                       final int fisherman) {
        super(nameOfShip, captainName,
                currentPort, maxSpeed, maxCapacity,
                currentLoad, currentSpeed);
        this.fisherman = fisherman;
        this.crewCount = crewCount;
    }

    public FishingShip(final double id, final String nameOfShip,
                       final String captainName, final String currentPort,
                       final double maxSpeed, final double maxCapacity,
                       final double currentLoad, final double currentSpeed,
                       final int crewCount, final int fisherman) {
        super(id, nameOfShip, captainName, currentPort,
                maxSpeed, maxCapacity, currentLoad, currentSpeed);
        this.fisherman = fisherman;
        this.crewCount = crewCount;
    }

    @Override
    public int getTotalPeopleCount() {
        return crewCount + fisherman;
    }

    @Override
    public double calculateLoadTime() {
        return currentLoad * minutes / tonn; }
    @Override
    public String getHeaders() {
        return super.getHeaders() + ",fisherman,crewCount";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ","
                + fisherman + ", "
                + crewCount;
    }
}
