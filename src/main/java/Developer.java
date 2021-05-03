import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee{
    List<Task> taskList;

    /*
    Parameterized Constructor for Developer
    */
    public Developer(int empID, String empName, float salary, int experience) {
        super(empID, empName, salary, experience);
        taskList = new ArrayList<Task>();
    }

    //Getters and setters
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    //Write your code below this
    @Override
    public void incrementSalary() {
        salary *=1.25;
    }

    public void completeTask(){
        for (Task t:taskList) {
            t.setStatus("Completed");
        }
    }

    public String completeTask(Task t){
        String message;
        if(taskList.contains(t)){
            t.setStatus("Completed");
            message="Completed";
        }else{
            message="Not Authorized";
        }
        return message;
    }

    @Override
    public void payUnionDues() {
        this.salary -= 75;
    }


}
