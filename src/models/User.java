package models;

import java.time.LocalDateTime;

/**
 * User model representing a logged-in system user.
 * Works with LoginManagementSystem and Dashboard.
 */
public class User {
    private String username;
    private String role;
    private LocalDateTime loginTime;

    // Constructor
    public User(String username, String role) {
        this.username = username;
        this.role = role;
        this.loginTime = LocalDateTime.now(); // record login timestamp
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    // Utility method for greeting or UI display
    public String getDisplayName() {
        String formattedRole = role.substring(0, 1).toUpperCase() + role.substring(1).toLowerCase();
        return formattedRole + " - " + username;
    }

    // String representation (for logs or debugging)
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
