public class Manager extends Employee {

    /*
    Parameterized Constructor for Manager
   */
    public Manager(int empID, String empName, float salary, int experience) {
        super(empID, empName, salary, experience);
    }

    //Write your code below this

    @Override
    public void incrementSalary() {
        salary *=1.15;
    }

    public String assign(Task t, Developer d){
        String message;
        if(((t.getLevel() ==3 && d.getExperience() >=5) || (t.getLevel()==2 && d.getExperience()>=3) || t.getLevel()==1) && t.getStatus().equalsIgnoreCase("Unassigned")) {
            d.getTaskList().add(t);
            t.setStatus("Assigned");
            message = "Assigned";
        }
        else
            message =  "Cannot Assign";
        return message;
    }

    @Override
    public void payUnionDues() {
        this.salary -= 100;
    }
}
