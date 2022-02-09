package Service;

import Entity.Driver;
import Menu.Menu;
import Util.CollectionUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DriverService {

    public void showDriver() {
        for (Driver driver : Menu.driverList) System.out.println(driver);
    }

    public void addNewDriver() {
        System.out.print("Nhập số lái xe muốn thêm mới: ");
        int driverNumber = -1;
        do {
            try {
                driverNumber = new Scanner(System.in).nextInt();
                if (driverNumber > 0) {
                    break;
                }
                System.out.print("Số lái xe muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lái xe muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < driverNumber; i++) {
            Driver driver = new Driver();
            driver.inputInfo();
            Menu.driverList.add(driver);
            Menu.driverDBUtil.insert(driver);
        }
    }

    public Driver findDriverById(int driverId) {
        for (Driver driver : Menu.driverList) {
            if (driver.getId() == driverId)
                return driver;
        }
        return null;
    }

    public void initializeDriverData() {
        List<Driver> driverList = Menu.driverDBUtil.getAll();
        if (!CollectionUtil.isEmpty(driverList)) {
            Driver.AUTO_ID = driverList.get(driverList.size() - 1).getId() + 1;
            Menu.driverList = driverList;
        } else {
            Menu.driverList = new ArrayList<>();
        }

    }
}
