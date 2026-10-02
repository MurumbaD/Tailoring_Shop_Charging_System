public class RepairJob extends Job {
/* we used extend above because RepairJob inherits from job
also means the id , name, loyal, getter, and other behaviours 
from job will be acquired*/

    private int quantity; //the repair-charge according to N.O.I

/* here i added the field of quantity and its behaviours with 
the other classes*/

    public RepairJob(String id, String customerName, boolean loyal, int quantity) {
        super(id, customerName, loyal);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//polymorphisp starts here ....
    @Override
    public double calculateCharge() {
        double charge = quantity * 10000; 
        // the inital charge is calculated here


        if (isLoyal()) {
            charge = charge * 0.92;// initally it was 8% so 100-8 = 92%
        }

        return charge;
    }
}
