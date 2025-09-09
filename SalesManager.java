package crmapp;
public class SalesManager extends User {
    private int approvalLimit;
    public SalesManager(String id, String name, String email, int approvalLimit) {
        super(id, name, "SalesManager", email);
        this.approvalLimit = approvalLimit;
    }
    public int getApprovalLimit() { return approvalLimit; }
    public void setApprovalLimit(int approvalLimit) { this.approvalLimit = approvalLimit; }
    public boolean approveDeal(int amount) { return amount <= approvalLimit; }
    @Override
    public void display() {
        System.out.println("SalesManager[" + getId() + "] " + getName() + " - approvalLimit=" + approvalLimit);
    }
}