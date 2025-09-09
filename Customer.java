package crmapp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Customer {
    private final String customerId;
    private String company;
    private String primaryContact;
    private List<String> contracts;
    private String sourceLeadId;
    private LocalDate createdDate;
    public Customer(String customerId, String company, String primaryContact, String sourceLeadId) {
        this.customerId = customerId; this.company = company; this.primaryContact = primaryContact;
        this.contracts = new ArrayList<>(); this.sourceLeadId = sourceLeadId; this.createdDate = LocalDate.now();
    }
    public String getCustomerId() { return customerId; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getPrimaryContact() { return primaryContact; }
    public void setPrimaryContact(String primaryContact) { this.primaryContact = primaryContact; }
    public List<String> getContracts() { return contracts; }
    public String getSourceLeadId() { return sourceLeadId; }
    public LocalDate getCreatedDate() { return createdDate; }
    public void addContract(String contractId) { contracts.add(contractId); }
    public void removeContract(String contractId) { contracts.remove(contractId); }
    public int totalContracts() { return contracts.size(); }
    public void display() {
        System.out.println("Customer[" + customerId + "] " + company + " - " + primaryContact +
                " contracts=" + totalContracts());
    }
    @Override
    public String toString() {
        return "Customer{" + customerId + "," + company + ",contracts=" + contracts.size() + "}";
    }
}