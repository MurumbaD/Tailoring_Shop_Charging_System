public abstract class Job implements Chargeable {

    private String id;
    private String customerName;
    private boolean loyal;
    
/* this recieves information when a job object is created */
    public Job(String id, String customerName, boolean loyal) {
        this.id = id;
        this.customerName = customerName;
        this.loyal = loyal;
    }

/* these allow you fetch or read details without accessing the private
fields */ 
    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean isLoyal() {
        return loyal;
    }

    public abstract double calculateCharge();
}
