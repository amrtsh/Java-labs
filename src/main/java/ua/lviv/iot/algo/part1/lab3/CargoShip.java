package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString(callSuper = true)
@Getter
@Setter
@SuppressWarnings("all")
public class CargoShip extends Ship {
    final public int minutes = 60;
    final public int tonn = 20;

    public int crewCount;
    public double tonnage;
    public String typeOfCargo;
    public CargoShip(final String nameOfShip, final String captainName,
                     final String currentPort, final double maxSpeed,
                     final double maxCapacity, final double currentLoad,
                     final double currentSpeed, final double tonnage,
                     final String typeOfCargo, final int crewCount) {
        super(nameOfShip, captainName, currentPort, maxSpeed, maxCapacity,
                currentLoad, currentSpeed);
        this.crewCount = crewCount;
        this.tonnage = tonnage;
        this.typeOfCargo = typeOfCargo;
    }

    public CargoShip(final double id, final String nameOfShip,
                     final String captainName, final String currentPort,
                     final double maxSpeed, final double maxCapacity,
                     final double currentLoad, final double currentSpeed,
                     final double tonnage,
                     final String typeOfCargo, final int crewCount) {
        super(id, nameOfShip, captainName, currentPort, maxSpeed, maxCapacity,
                currentLoad, currentSpeed);
        this.crewCount = crewCount;
        this.tonnage = tonnage;
        this.typeOfCargo = typeOfCargo;
    }

    @Override
    public int getTotalPeopleCount() { return crewCount; }
    @Override
    public double calculateLoadTime() {
        return currentLoad * minutes / tonn; }

}
