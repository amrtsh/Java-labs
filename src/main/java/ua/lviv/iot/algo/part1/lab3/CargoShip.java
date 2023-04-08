package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString(callSuper = true)
@Getter
@Setter
public class CargoShip extends Ship {
    private int crewCount;
    private double tonnage;
    private String typeOfCargo;
    public CargoShip(String nameOfShip, String captainName, String currentPort, double maxSpeed,
                     double maxCapacity, double currentLoad, double currentSpeed, double tonnage, String typeOfCargo, int crewCount) {
        super(nameOfShip, captainName, currentPort, maxSpeed, maxCapacity,
                currentLoad, currentSpeed);
        this.crewCount = crewCount;
        this.tonnage = tonnage;
        this.typeOfCargo = typeOfCargo;
    }

    public CargoShip(double id, String nameOfShip, String captainName, String currentPort, double maxSpeed,
                     double maxCapacity, double currentLoad, double currentSpeed, double tonnage, String typeOfCargo, int crewCount) {
        super(id, nameOfShip, captainName, currentPort, maxSpeed, maxCapacity,
                currentLoad, currentSpeed);
        this.crewCount = crewCount;
        this.tonnage = tonnage;
        this.typeOfCargo = typeOfCargo;
    }

    @Override
    public int getTotalPeopleCount() {
        return crewCount;
    }

    @Override
    public double calculateLoadTime() {
        return currentLoad * 60 / 20;
    }
}
