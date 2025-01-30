package main.singly_linked_list.student_management;

public class StudentManagement {
    public static void main(String[] args) {
        LinkedStudent ls = new LinkedStudent();
        ls.add("Vivek", 23, 202, "A",0);
        ls.add("Bhavya", 21, 15, "A++",0);
        ls.add("Riya", 21, 47, "B+",0);

        System.out.println("All Students:");
        ls.display();

        System.out.println("\nDisplay main.singly_linked_list.student_management.Student by Roll Number:");
        ls.displayByRoll(202);

        System.out.println("\nUpgrade Grade:");
        ls.upgradeGrade(15, "A");
        ls.display();

        System.out.println("\nDelete a main.singly_linked_list.student_management.Student:");
        ls.delete(47);
        ls.display();
    }
}
