package crmapp;
public class User {
    private final String id;
    private String name;
    private String role;
    private String email;
    private boolean active;
    public User(String id, String name, String role, String email) {
        this.id = id; this.name = name; this.role = role; this.email = email; this.active = true;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public void display() {
        System.out.println("User[" + id + "] " + name + " (" + role + ") - " + email);
    }
    @Override
    public String toString() {
        return "User{" + id + "," + name + "," + role + "," + email + "}";
    }
}