package Entity.Point;

import Entity.Driver;

import java.util.List;

public class AssignmentTable {
    private Driver driver;

    private List<Assignment> assignmentList;

    public AssignmentTable(Driver driver, List<Assignment> assignmentList) {
        this.driver = driver;
        this.assignmentList = assignmentList;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public String toString() {
        return "AssignmentTable{" +
                "driver=" + driver +
                ", assignmentList=" + assignmentList +
                '}';
    }
}
