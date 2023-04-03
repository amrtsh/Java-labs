package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public  class MilitaryShip extends Ship {
    private int military;
    private int crewCount;
public MilitaryShip(double id, String nameOfShip, String captainName, String currentPort, double maxSpeed, double maxCapacity, double currentLoad, double currentSpeed, int military, int crewCount) {
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
        return currentLoad * 60 / 20;
        }
}
