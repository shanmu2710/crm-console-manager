package crmapp;
import java.time.LocalDate;
import java.util.*;
public class CRMManager {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Lead> leads = new HashMap<>();
    private Map<String, Customer> customers = new HashMap<>();
    public void addUser(User user) { users.put(user.getId(), user); }
    public Optional<User> getUser(String id) { return Optional.ofNullable(users.get(id)); }
    public void addLead(Lead lead) { leads.put(lead.getLeadId(), lead); }
    public Optional<Lead> getLead(String leadId) { return Optional.ofNullable(leads.get(leadId)); }
    public Customer convertLead(String leadId) {
        Lead l = leads.get(leadId);
        if (l == null) throw new IllegalArgumentException("Lead not found: " + leadId);
        String cid = "CUST-" + UUID.randomUUID().toString().substring(0,6);
        Customer c = new Customer(cid, l.getCompany(), l.getContactPerson(), l.getLeadId());
        customers.put(cid, c); l.setStatus("CONVERTED"); return c;
    }
    public List<Lead> searchLeads(String nameOrCompany) {
        List<Lead> res = new ArrayList<>();
        for (Lead l : leads.values()) {
            if (l.getCompany().toLowerCase().contains(nameOrCompany.toLowerCase()) ||
                l.getContactPerson().toLowerCase().contains(nameOrCompany.toLowerCase())) res.add(l);
        } return res;
    }
    public Optional<Lead> searchLeadsByPhone(String phone) {
        for (Lead l : leads.values()) if (l.getPhone().equals(phone)) return Optional.of(l);
        return Optional.empty();
    }
    public List<Lead> searchLeadsByScoreRange(int minScore, int maxScore) {
        List<Lead> res = new ArrayList<>();
        for (Lead l : leads.values()) if (l.getScore() >= minScore && l.getScore() <= maxScore) res.add(l);
        return res;
    }
    public List<Lead> listByStatus(String status) {
        List<Lead> res = new ArrayList<>();
        for (Lead l : leads.values()) if (status.equalsIgnoreCase(l.getStatus())) res.add(l);
        return res;
    }
    public Map<String, Integer> leadsPerOwner() {
        Map<String, Integer> m = new HashMap<>();
        for (Lead l : leads.values()) {
            String owner = (l.getOwner() != null ? l.getOwner().getName() : "Unassigned");
            m.put(owner, m.getOrDefault(owner, 0) + 1);
        } return m;
    }
    public List<Customer> conversionsSince(LocalDate since) {
        List<Customer> res = new ArrayList<>();
        for (Customer c : customers.values()) if (!c.getCreatedDate().isBefore(since)) res.add(c);
        return res;
    }
    public Collection<Lead> getAllLeads() { return leads.values(); }
    public Collection<Customer> getAllCustomers() { return customers.values(); }
}