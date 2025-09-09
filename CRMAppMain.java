package crmapp;
import java.time.LocalDate;
public class CRMAppMain {
    public static void main(String[] args) {
        CRMManager mgr = new CRMManager();
        User u1 = new User("U1","Alice","SalesRep","alice@crm.com");
        User u2 = new SalesManager("U2","Bob","bob@crm.com", 50000);
        mgr.addUser(u1); mgr.addUser(u2);
        Lead l1 = new Lead("L1","InnoTech","Sam","9991110001", 80, u1);
        Lead l2 = new Lead("L2","BlueSoft","Ria","9991110002", 45, u2);
        Lead l3 = new Lead("L3","GreenEdge","Tom","9991110003", 72, u1);
        l1.updateStatus("CONTACTED"); l2.updateStatus("CONTACTED");
        mgr.addLead(l1); mgr.addLead(l2); mgr.addLead(l3);
        System.out.println("-- All Leads --");
        for (Lead l : mgr.getAllLeads()) l.display();
        System.out.println("\n-- Search by name/company 'Green' --");
        for (Lead r : mgr.searchLeads("Green")) r.display();
        System.out.println("\n-- Search by phone 9991110002 --");
        mgr.searchLeadsByPhone("9991110002").ifPresent(Lead::display);
        System.out.println("\n-- Convert L1 to Customer --");
        Customer c1 = mgr.convertLead("L1"); c1.display();
        c1.addContract("CON-001"); System.out.println("After adding contract:"); c1.display();
        System.out.println("\n-- Leads by Status CONTACTED --");
        for (Lead l : mgr.listByStatus("CONTACTED")) l.display();
        System.out.println("\n-- Leads per Owner --");
        mgr.leadsPerOwner().forEach((k,v)-> System.out.println(k+": "+v));
        System.out.println("\n-- Conversions this week --");
        LocalDate weekStart = LocalDate.now().minusDays(7);
        for (Customer c : mgr.conversionsSince(weekStart)) c.display();
        System.out.println("\n-- Users (polymorphism) --");
        u1.display(); u2.display();
    }
}