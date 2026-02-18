package service;

import model.Admin;
import java.util.ArrayList;

public class AdminService {

    private ArrayList<Admin> admins = new ArrayList<>();

    // Constructor: add a default admin (VERY useful for testing & exams)
    public AdminService() {
        admins.add(new Admin(
                1,
                "System Admin",
                "admin@rental.com",
                "admin",
                "admin123"
        ));
    }

    // Add new admin
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    // Admin login using username & password
    public Admin login(String username, String password) {
        for (Admin a : admins) {
            if (a.getUsername().equals(username)
                    && a.getPassword().equals(password)) {
                return a;
            }
        }
        return null;
    }

    // Find admin by ID
    public Admin getAdminById(int adminId) {
        for (Admin a : admins) {
            if (a.getAdminId() == adminId) {
                return a;
            }
        }
        return null;
    }

    // Find admin by email
    public Admin getAdminByEmail(String email) {
        for (Admin a : admins) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return a;
            }
        }
        return null;
    }

    // View all admins (optional but exam-friendly)
    public ArrayList<Admin> getAllAdmins() {
        return admins;
    }
}

