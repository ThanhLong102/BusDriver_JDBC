package Util.File;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Driver;

public class DriverDBUtil implements DataReadable<Driver>, DataWritable<Driver> {

    @Override
    public List<Driver> readDataFromDB() {
        List<Driver> driverList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "anhhieu123");

            Statement statement = connection.createStatement();

            String sql = "Select ID, NAME, ADDRESS, NUMBER_PHONE, DEGREE from LAIXE ORDER BY ID";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String address = rs.getString(3);
                String phoneNumber = rs.getString(4);
                String driveLevel = rs.getString(5);
                Driver driver = new Driver(fullname, address, phoneNumber, id, driveLevel);
                driverList.add(driver);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return driverList;
    }

    @Override
    public void writeDataToDB(Driver driver) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "anhhieu123");

            String sql = "INSERT INTO LAIXE (ID, NAME, ADDRESS, NUMBER_PHONE, DEGREE) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, driver.getId());
            pstmt.setString(2, driver.getFullName());
            pstmt.setString(3, driver.getAddress());
            pstmt.setString(4, driver.getPhone());
            pstmt.setString(5, driver.getDriveLevel());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
