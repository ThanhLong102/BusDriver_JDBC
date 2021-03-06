package Entity;

import java.util.Scanner;

public class Person{
    protected String fullName;
    protected String address;
    protected String phone;

    public Person() {
    }

    public Person(String fullName, String address, String phone) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void inputInfo() {
        System.out.print("Nhập tên lái xe: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.print("Nhập tên địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        intputPhoneNumber();
    }

    public void intputPhoneNumber(){
        System.out.print("Nhập số dt : ");
        String phoneNumber = "";
        do {
            phoneNumber=new Scanner(System.in).nextLine();
            if (phoneNumber.matches("\\d+")) {
                this.phone = phoneNumber;
                break;
            }
            System.out.println("Số điện thoại chỉ nhập số");
        } while (true);
    }

    @Override
    public String toString() {
        return "Person{" + "fullName='" + fullName + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + '}';
    }

}
