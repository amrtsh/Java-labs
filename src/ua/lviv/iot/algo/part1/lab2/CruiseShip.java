package ua.lviv.iot.algo.part1.lab2;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString(callSuper = true)
@Getter
@Setter
public class CruiseShip extends Ship {
    private int passangersCount;
    private int crewCount;
    private int numberOfSupportStaff;

    public CruiseShip(String nameOfShip, String captainName, String currentPort, double maxSpeed, double maxCapacity, double currentLoad, double currentSpeed, int passangersCount, int crewCount, int numberOfSupportStaff) {
        super(nameOfShip, captainName, currentPort, maxSpeed, maxCapacity,
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
        return getTotalPeopleCount() * 5 / 60.0;
    }
}
