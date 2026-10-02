import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* notice here we used the import java.util.Comparator; as the 
course work required. and also list and array list for collections of the information */

public class JobManager {

    private List<Job> jobs;// this is the most important line (collection of all jobs)

    public JobManager() {
        jobs = new ArrayList<>();
    }
    /* we then create the ArrayList so that we can store inputs */

    public void addJob(Job job) {
        jobs.add(job); // then this allows us add a job i.e RepairJob, NewGermentJob
    }
/* polymorphism is here because that will treat them as Job */ 


    public Job findJob(String id) {
        for (Job job : jobs) {
            if (job.getId().equalsIgnoreCase(id)) {
                return job;
            }
        }

        return null;
    }
    /* incase you want to go through and search for the job it will look 
    for the job in the ArrayList looking for a match */
    

    public boolean removeJob(String id) {
        Job job = findJob(id);

        if (job != null) {
            jobs.remove(job);  // find and remove if job exists...
            return true;  // this is later corrected in ExceptionS to avoid returning null 
        }

        return false;
    }
/* this down here is the most important why,because we have 
different types of jobs in the list but simply
call (job.calculateCharge) in RepairJob,
NewGermentJob "the actual polymorphism": */

    public double getTotalCharges() {
        double total = 0;

        for (Job job : jobs) {
            total += job.calculateCharge();
        }

        return total;
    }

    public double getTotalDiscount() {
        double totalDiscount = 0;

        for (Job job : jobs) {
            if (job.isLoyal()) {
                double finalCharge = job.calculateCharge();
                double originalCharge = finalCharge / 0.92;
                totalDiscount += originalCharge - finalCharge;
            }
        }

        return totalDiscount;
    }
/* the sorting will appear here since i have a A=2 */
    public List<Job> getJobsSorted() {
        List<Job> sortedJobs = new ArrayList<>(jobs);

        sortedJobs.sort(
            Comparator.comparing(Job::getCustomerName, String.CASE_INSENSITIVE_ORDER)
        );// simply means values will be aligned to the next line not on the same list 

        return sortedJobs;
    }
}
