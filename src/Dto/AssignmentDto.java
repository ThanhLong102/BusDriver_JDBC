package Dto;

import Entity.Driver;
import Entity.Line;

public class AssignmentDto {
    private Driver driver;

    private Line line;

    private int turnNumber;

    public AssignmentDto(Driver driver, Line line, int turnNumber) {
        this.driver = driver;
        this.line = line;
        this.turnNumber = turnNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
}
