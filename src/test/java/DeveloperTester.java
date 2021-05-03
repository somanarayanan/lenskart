import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeveloperTester {

    Developer d;
    Task t1,t2,t3,t4,t5,t6;
    @BeforeEach
    public  void setUp(){
        d=new Developer(1,"DevDood",25000,5);

        t1 = new Task(1,"Test Task 1","Dummy Test Task", 1, "assigned");
        t2 = new Task(2,"Test Task 2","Dummy Test Task", 2, "assigned");
        t3 = new Task(3,"Test Task 3","Dummy Test Task", 3, "assigned");
        t4 = new Task(4,"Test Task 4","Dummy Test Task", 3, "assigned");
        t5 = new Task(5,"Test Task 5","Dummy Test Task", 2, "assigned");
        t6 = new Task(6,"Test Task 6","Dummy Test Task", 1, "assigned");

        d.getTaskList().add(t1);
        d.getTaskList().add(t2);
        d.getTaskList().add(t3);
        d.getTaskList().add(t4);
        d.getTaskList().add(t5);

    }

    @Test
    public void testIncrementSalary(){
        d.incrementSalary();
        Assertions.assertEquals(d.getSalary(),31250);
    }

    @Test
    public void testPayUnionDues(){
        d.payUnionDues();
        Assertions.assertEquals(d.getSalary(),24925);
    }

    @Test
    public void testCompleteTask(){
        //A developer cannot complete a task not assigned to him
        Assertions.assertTrue(d.completeTask(t6).equalsIgnoreCase("Not authorized"));

        //A developer can complete a task in his task list
        Assertions.assertTrue(d.completeTask(t5).equalsIgnoreCase("Completed"));

        //Task status must be 'Completed' after completion
        Assertions.assertTrue(t5.getStatus().equalsIgnoreCase("Completed"));

        d.completeTask();

        //Task status must be 'Completed' after completion
        Assertions.assertTrue(t1.getStatus().equalsIgnoreCase("Completed"));
        Assertions.assertTrue(t2.getStatus().equalsIgnoreCase("Completed"));
        Assertions.assertTrue(t3.getStatus().equalsIgnoreCase("Completed"));
        Assertions.assertTrue(t4.getStatus().equalsIgnoreCase("Completed"));

    }
}
