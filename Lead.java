package crmapp;
import java.time.LocalDate;
public class Lead {
    private final String leadId;
    private String company;
    private String contactPerson;
    private String phone;
    private String status;
    private int score;
    private User owner;
    private LocalDate createdDate;
    public Lead(String leadId, String company, String contactPerson, String phone, int score, User owner) {
        this.leadId = leadId; this.company = company; this.contactPerson = contactPerson; this.phone = phone;
        this.status = "NEW"; this.score = score; this.owner = owner; this.createdDate = LocalDate.now();
    }
    public String getLeadId() { return leadId; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public LocalDate getCreatedDate() { return createdDate; }
    public boolean isQualified() { return score >= 70 && "CONTACTED".equalsIgnoreCase(status); }
    public void updateStatus(String newStatus) { this.status = newStatus; }
    public void display() {
        System.out.println("Lead[" + leadId + "] " + company + " - " + contactPerson +
                " (" + phone + ") status=" + status + " score=" + score +
                " owner=" + (owner != null ? owner.getName() : "none"));
    }
    @Override
    public String toString() {
        return "Lead{" + leadId + "," + company + "," + contactPerson +
                ",status=" + status + ",score=" + score + "}";
    }
}