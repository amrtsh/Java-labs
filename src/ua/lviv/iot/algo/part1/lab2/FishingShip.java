package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public  class FishingShip extends Ship{
    private int fisherman;
    private int crewCount;
    public FishingShip(String nameOfShip, String captainName, String currentPort, double maxSpeed,
                   double maxCapacity, double currentLoad, double currentSpeed,int crewCount, int fisherman) {
        super(nameOfShip, captainName, currentPort, maxSpeed, maxCapacity, currentLoad, currentSpeed);
        this.fisherman = fisherman;
        this.crewCount = crewCount;
    }

    @Override
    public int getTotalPeopleCount() {

        return crewCount + fisherman;
    }

    @Override
    public double calculateLoadTime() {

        return currentLoad * 60 / 20;
    }
}