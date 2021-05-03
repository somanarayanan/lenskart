abstract public class Employee implements  EmployeeUnion{
    int empID;
    String empName;
    float salary;
    int experience;

    public Employee(int empID, String empName, float salary, int experience) {
        this.empID = empID;
        this.empName = empName;
        this.salary = salary;
        this.experience = experience;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    //Write your code below this

    abstract public void incrementSalary();

}
