import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTester {

    private Manager mgr;

    @BeforeEach
    public  void setUp(){
        mgr=new Manager(1,"Big Boss",40000, 15);
    }

    @Test
    public void testIncrementSalary(){
        mgr.incrementSalary();
        Assertions.assertEquals(mgr.getSalary(),46000);
    }

    @Test
    public void testPayUnionDues(){
        mgr.payUnionDues();
        Assertions.assertEquals(mgr.getSalary(),39900);
    }

    @Test
    public void testAssignTask(){
        Developer d1 = new Developer(1,"Dude",25000, 5);
        Developer d2 = new Developer(2,"Dude",25000, 3);
        Developer d3 = new Developer(3,"Dude",25000, 2);
        Developer d4 = new Developer(4,"Dude",25000, 6);

        Task t1 = new Task(1,"Test Task 1","Dummy Test Task", 1, "unassigned");
        Task t2 = new Task(2,"Test Task 2","Dummy Test Task", 2, "unassigned");
        Task t3 = new Task(3,"Test Task 3","Dummy Test Task", 3, "unassigned");
        Task t4 = new Task(4,"Test Task 4","Dummy Test Task", 3, "unassigned");
        Task t5 = new Task(5,"Test Task 5","Dummy Test Task", 2, "unassigned");
        Task t6 = new Task(6,"Test Task 6","Dummy Test Task", 1, "unassigned");

        //Should not assign level 3 task to developer with 2 years experience
        Assertions.assertTrue(mgr.assign(t3,d3).equalsIgnoreCase("Cannot assign"));

        //Should not assign level 3 task to developer with 3 years experience
        Assertions.assertTrue(mgr.assign(t3,d2).equalsIgnoreCase("Cannot assign"));

        //Should assign level 3 task to developer with 5 years experience
        Assertions.assertTrue(mgr.assign(t3, d1).equalsIgnoreCase("Assigned"));

        //Should not assign level 2 task to developer with 2 years experience
        Assertions.assertTrue(mgr.assign(t2,d3).equalsIgnoreCase("Cannot assign"));

        //Should assign level 2 task to developer with 3 years experience
        Assertions.assertTrue(mgr.assign(t2,d2).equalsIgnoreCase("Assigned"));

        //Should assign level 1 task to any developer
        Assertions.assertTrue(mgr.assign(t1,d3).equalsIgnoreCase("Assigned"));

        //Should assign level 1 task to developer with 5 years experience
        Assertions.assertTrue(mgr.assign(t6,d1).equalsIgnoreCase("Assigned"));

        //Should assign level 2 task to developer with 5 years experience
        Assertions.assertTrue(mgr.assign(t5,d1).equalsIgnoreCase("Assigned"));

        //Should assign level 3 task to developer with 6 years experience
        Assertions.assertTrue(mgr.assign(t4,d4).equalsIgnoreCase("Assigned"));

        //Already assigned task must not be assigned to another developer
        Assertions.assertTrue(mgr.assign(t3,d4).equalsIgnoreCase("Cannot Assign"));

        //Task status must be 'assigned' after assigning
        Assertions.assertTrue(t1.getStatus().equalsIgnoreCase("Assigned"));
        Assertions.assertTrue(t2.getStatus().equalsIgnoreCase("Assigned"));
        Assertions.assertTrue(t3.getStatus().equalsIgnoreCase("Assigned"));
        Assertions.assertTrue(t4.getStatus().equalsIgnoreCase("Assigned"));
        Assertions.assertTrue(t5.getStatus().equalsIgnoreCase("Assigned"));
        Assertions.assertTrue(t6.getStatus().equalsIgnoreCase("Assigned"));


        Assertions.assertEquals(d1.getTaskList().size(),3);
        Assertions.assertEquals(d2.getTaskList().size(),1);
        Assertions.assertEquals(d3.getTaskList().size(),1);
        Assertions.assertEquals(d4.getTaskList().size(),1);


    }


}
