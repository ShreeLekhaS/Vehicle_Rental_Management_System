package model;

public class Admin {

    private int adminId;
    private String name;
    private String email;
    private String username;
    private String password;

    public Admin(int adminId, String name, String email,
                 String username, String password) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}