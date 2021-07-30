import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private int ID;
    private String taskTypeId;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;

    public Task() {
    }

    public Task(int ID, String taskTypeId, String requirementName, Date date, double planFrom, double planTo, String assign, String reviewer) {
        this.ID = ID;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getassign() {
        return assign;
    }

    public void setassign(String assign) {
        this.assign = assign;
    }

    public String getreviewer() {
        return reviewer;
    }

    public void setreviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public void display(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String d = format.format(date);
        System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",ID,requirementName,
        taskTypeId,d,planTo - planFrom,assign,reviewer);
    }

    

}
