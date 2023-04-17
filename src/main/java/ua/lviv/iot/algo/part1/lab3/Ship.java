package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
@Setter
@SuppressWarnings("all")
public abstract class Ship {
    protected double id;
    protected String nameOfShip;
    protected String captainName;
    protected String currentPort;
    protected double maxSpeed;
    protected double maxCapacity;
    protected double currentLoad;
    protected double currentSpeed;

    public abstract int getTotalPeopleCount();

    public abstract double calculateLoadTime();

    public Ship(final String nameOfShip, final String captainName, final String currentPort, final double maxSpeed,
                final double maxCapacity, final double currentLoad, final double currentSpeed) {
        this.id = 10.4;
        this.nameOfShip = nameOfShip;
        this.captainName = captainName;
        this.currentPort = currentPort;
        this.maxSpeed = maxSpeed;
        this.maxCapacity = maxCapacity;
        this.currentLoad = currentLoad;
        this.currentSpeed = currentSpeed;
    }

    public Ship(final double id, final String nameOfShip, final String captainName, final String currentPort, final double maxSpeed,
                final double maxCapacity, final double currentLoad, final double currentSpeed) {
        this.id = id;
        this.nameOfShip = nameOfShip;
        this.captainName = captainName;
        this.currentPort = currentPort;
        this.maxSpeed = maxSpeed;
        this.maxCapacity = maxCapacity;
        this.currentLoad = currentLoad;
        this.currentSpeed = currentSpeed;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return Double.compare(ship.id, id) == 0 && Double.compare(ship.maxSpeed, maxSpeed) == 0 && Double.compare(ship.maxCapacity, maxCapacity) == 0 && Double.compare(ship.currentLoad, currentLoad) == 0 && Double.compare(ship.currentSpeed, currentSpeed) == 0 && Objects.equals(nameOfShip, ship.nameOfShip) && Objects.equals(captainName, ship.captainName) && Objects.equals(currentPort, ship.currentPort);
    }
}