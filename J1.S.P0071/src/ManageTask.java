import java.util.Date;
import java.util.ArrayList;

public class ManageTask {

  
    private ArrayList<Task> list;

    public ManageTask(){
        list = new ArrayList<>();
    }
    
    public void displayMenu(){
        System.out.println("======== Task Program =======");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }


    public void addTask(){
        System.out.println("======== Add Task =======");
        int ID = 0;
        if(list.isEmpty()){
            ID = 1;
        }
        else{
            ID = list.get(list.size() - 1).getId() + 1;
        }
        System.out.print("Requirment Name: ");
        String requirementName = Validation.checkString();
        requirementName = normalizeString(requirementName);
        System.out.print("Task Type(1 Code,2 Test,3 Manager,4 Learn): ");
        int input = Validation.checkInput();
        String taskTypeID = getTaskType(input);

        System.out.print("Date: ");
        Date date = Validation.checkInputDate();
        System.out.print("From: ");
        double planFrom = Validation.checkPlan();
        System.out.print("To: ");
        double planTo = Validation.checkPlan();
        if(conditionOfPlanTime(planFrom, planTo) == false){
            System.out.println("PlanTo Time must be greater than PlanFrom Time");
            System.out.println("Enter again: ");
            planTo = Validation.checkPlan();
        }
        System.out.print("Enter Assignee: ");
        String assign = Validation.checkString();
        assign = normalizeString(assign);
        System.out.print("Enter Reviewer: ");
        String reviewer = Validation.checkString();
        reviewer = normalizeString(reviewer);
        list.add(new Task(ID, taskTypeID, requirementName, date, planFrom, planTo, assign, reviewer));
        System.out.println("Add Task Success.");

    }

    private boolean conditionOfPlanTime(double planFrom,double planTo){
        if(planFrom > planTo){
            return false;
        }
        return true;
    }

    private static String normalizeString(String input){
        input = input.replaceAll("\\s+", " ");
        String[] temp= input.split(" ");
        String res = "";
        for(int i = 0;i < temp.length;i++){
            res += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i<temp.length-1) 
                res += " "; 
        }
        return res;
    }

    private static String getTaskType(int task){
        String name = "";
        switch(task){
            case 1:
                name = "code";
                break;
            case 2:
                name = "test";
                break;
            case 3:
                name = "manager";
                break;
            case 4:
                name = "learn";
                break;
            }
        return name;
    }

    private int getIndexOfID(int ID){
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getId() == ID){
                return i;
            }
        }
        return -1;// ID ko ton tai
    }

    public void deleteTask(){
        if(list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("======== Delete Task =======");
        System.out.print("Enter ID to Delete: ");
        int id = Validation.checkInteger();
        int index = getIndexOfID(id);
        if(index == -1){
            System.out.println("ID doesn't exsited");
            return;
        }
        Task task = list.get(index);
        list.remove(task);
        System.out.println("Delete Task Success");
        // displayTask(list);
    }

    public void displayTask(){
        System.out.println("----------------------- Task -----------------------");
        if(list.isEmpty()){
            System.out.println("Your List is Empty");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
        "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for(Task t : list){
            t.display();
        }
    }
}
