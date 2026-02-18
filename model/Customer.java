package model;

public class Customer {

    private int customerId;
    private String name;
    private String phone;
    private String email;
    private int age;
    private String address;

    public Customer(int customerId, String name, String phone,
                    String email, int age, String address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
