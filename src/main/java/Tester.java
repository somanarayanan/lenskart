public class Tester {
    public static void main(String[] args) {
       Task t1 = new Task(1,"Test Task 1","Dummy Test Task", 1, "assigned");
       Task t2 = new Task(2,"Test Task 2","Dummy Test Task", 2, "assigned");
       Task t3 = new Task(3,"Test Task 3","Dummy Test Task", 3, "assigned");
       Task t4 = new Task(4,"Test Task 4","Dummy Test Task", 3, "assigned");

        t1.setTaskID(1);
        t1.setLevel(5);
        t2.setTaskID(2);
        t2.setLevel(3);
        t3.setTaskID(3);
        t3.setLevel(2);
        t4.setTaskID(4);
        t4.setLevel(3);

        Manager m = new Manager(1,"Ronin", 40000, 11);
        Developer d1 = new Developer(2, "Yuri", 35000, 5);
        Developer d2 = new Developer(3, "Neil", 40000, 8);

        System.out.print("daiiii sodhikadha");
        //Uncomment the below code and add your own liens for testing




        m.assign(t1, d2);
        m.assign(t2,d2);
        m.assign(t3,d1);
        m.assign(t4,d1);


        d1.completeTask(t1);
        d1.completeTask(t3);

        d2.completeTask();



    }
}
