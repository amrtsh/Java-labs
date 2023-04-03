package ua.lviv.iot.algo.part1.lab2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public abstract class Ship {
    static double id = 10.4;
    protected String nameOfShip;
    protected String captainName;
    protected String currentPort;
    protected double maxSpeed;
    protected double maxCapacity;
    protected double currentLoad;
    protected double currentSpeed;

    public abstract int getTotalPeopleCount();

    public abstract double calculateLoadTime();


    public Ship(double id, String nameOfShip, String captainName, String currentPort, double maxSpeed,
                double maxCapacity, double currentLoad, double currentSpeed) {
        Ship.id = 10.4;
        this.nameOfShip = nameOfShip;
        this.captainName = captainName;
        this.currentPort = currentPort;
        this.maxSpeed = maxSpeed;
        this.maxCapacity = maxCapacity;
        this.currentLoad = currentLoad;
        this.currentSpeed = currentSpeed;
    }
}




