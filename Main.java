public class Main {

    public static void main(String[] args) {

        JobManager manager = new JobManager();
        InputHelper input = new InputHelper();

        System.out.println("************   *********** *************");
        System.out.println("       TAILORING SHOP CHARGING SYSTEM");
        System.out.println("************   *********** *************");
        System.out.println("Name: MURUMBA DAVID SYDNEY");
        System.out.println("Registration: VU-BIT-2607-3239-EVE");
        System.out.println();

        boolean running = true;

        while (running) {

            showMenu();

            int choice = input.getMenuChoice();

            switch (choice) {

                case 1:
                    addRepairJob(manager, input);
                    break;

                case 2:
                    addNewGarmentJob(manager, input);
                    break;

                case 3:
                    listJobs(manager);
                    break;

                case 4:
                    findJob(manager, input);
                    break;

                case 5:
                    removeJob(manager, input);
                    break;

                case 6:
                    showSummary(manager);
                    break;

                case 7:
                    running = false;
                    System.out.println("Thank you for using the system.");
                    break;
            }
        }
    }

    public static void showMenu() {

        System.out.println();
        System.out.println("--------------- MENU ----------------");
        System.out.println("1. Add Repair Job");
        System.out.println("2. Add New Garment Job");
        System.out.println("3. List Jobs");
        System.out.println("4. Find Job");
        System.out.println("5. Remove Job");
        System.out.println("6. Show Summary");
        System.out.println("7. Exit");
        System.out.println("-------------------------------------");
    }

    public static void addRepairJob(JobManager manager, InputHelper input) {

        System.out.println();
        System.out.println("ADD REPAIR JOB");

        String id = input.getString("Enter job ID: ");
        String name = input.getString("Enter customer name: ");
        boolean loyal = input.getYesNo("Is the customer loyal? (yes/no): ");
        int quantity = input.getInt("Enter number of items: ");

        RepairJob job = new RepairJob(id, name, loyal, quantity);

        manager.addJob(job);

        System.out.println("Repair job added successfully.");
    }

    public static void addNewGarmentJob(JobManager manager, InputHelper input) {

        System.out.println();
        System.out.println("ADD NEW GARMENT JOB");

        String id = input.getString("Enter job ID: ");
        String name = input.getString("Enter customer name: ");
        boolean loyal = input.getYesNo("Is the customer loyal? (yes/no): ");
        double fabricCost = input.getDouble("Enter fabric cost: ");

        NewGarmentJob job =
                new NewGarmentJob(id, name, loyal, fabricCost);

        manager.addJob(job);

        System.out.println("New garment job added successfully.");
    }

    public static void listJobs(JobManager manager) {

        System.out.println();
        System.out.println("----------- JOB REPORT -----------");

        if (manager.getJobsSorted().isEmpty()) {
            System.out.println("No jobs have been added.");
            return;
        }

        for (Job job : manager.getJobsSorted()) {

            System.out.println("ID: " + job.getId());
            System.out.println("Customer: " + job.getCustomerName());
            System.out.println("Type: " + job.getClass().getSimpleName());
            System.out.printf("Charge: UGX %.2f%n", job.calculateCharge());
            System.out.println("---------------------------------");
        }
    }

    public static void findJob(JobManager manager, InputHelper input) {

        System.out.println();
        System.out.println("FIND JOB");

        String id = input.getString("Enter job ID: ");

        Job job = manager.findJob(id);

        if (job == null) {
            System.out.println("Job not found.");
            return;
        }

        System.out.println("Job found.");
        System.out.println("ID: " + job.getId());
        System.out.println("Customer: " + job.getCustomerName());
        System.out.println("Type: " + job.getClass().getSimpleName());
        System.out.printf("Charge: UGX %.2f%n", job.calculateCharge());
    }

    public static void removeJob(JobManager manager, InputHelper input) {

        System.out.println();
        System.out.println("REMOVE JOB");

        String id = input.getString("Enter job ID: ");

        Job job = manager.findJob(id);

        if (job == null) {
            System.out.println("Job not found.");
            return;
        }

        boolean confirm = input.getYesNo(
                "Are you sure you want to remove this job? (yes/no): ");

        if (confirm) {
            manager.removeJob(id);
            System.out.println("Job removed successfully.");
        } else {
            System.out.println("Removal cancelled.");
        }
    }

    public static void showSummary(JobManager manager) {

        System.out.println();
        System.out.println("------------- SUMMARY -------------");

        System.out.printf(
                "Total charges: UGX %.2f%n",
                manager.getTotalCharges()
        );

        System.out.printf(
                "Total discount given: UGX %.2f%n",
                manager.getTotalDiscount()
        );

        System.out.println("-----------------------------------");
    }
}
