public class NewGarmentJob extends Job {
/* same as the previous one the repairjob.java inheritance */
    private double fabricCost;// stores amount of fabricCost

    public NewGarmentJob(String id, String customerName, boolean loyal, double fabricCost) {
        super(id, customerName, loyal);// sends common information to the job class
        this.fabricCost = fabricCost;
    }

    public double getFabricCost() {
        return fabricCost;
    }

    public void setFabricCost(double fabricCost) {
        this.fabricCost = fabricCost;
    }

    @Override
    public double calculateCharge() {
        double charge = fabricCost + 40000;

        if (isLoyal()) {
            charge = charge * 0.92;// the loyal customer discount 
        }
        /*we came up with the because discount = 3("my reg no digit") + 5 = 8%
        therefore if the customer pays 92% of the original charge 
        then return true */

        return charge;
    }
}
