package main.singly_linked_list.student_management;

public class LinkedStudent {
    Student student;

    // Add a student to the list
    public void add(String name, int age, int rollno, String grade, int pos) {
        Student temp = new Student(name, age, rollno, grade, null);

        // If adding at the head of the list
        if (pos == 0) {
            temp.next = student;
            student = temp;
            return;
        }

        Student current = student;
        int currentIndex = 0;

        // Traverse the list to find the correct position
        while (current != null && currentIndex < pos - 1) {
            current = current.next;
            currentIndex++;
        }

        // If `pos` is out of range
        if (current == null) {
            System.out.println("Invalid position: " + pos);
            return;
        }

        // Insert the new node at the specified position
        temp.next = current.next;
        current.next = temp;
    }


    // Display all students
    public void display() {
        if (student == null) {
            System.out.println("main.singly_linked_list.student_management.Student list is empty.");
            return;
        }

        Student t = student;
        while (t != null) {
            System.out.println("Name: " + t.name);
            System.out.println("Age: " + t.age);
            System.out.println("Roll Number: " + t.rollno);
            System.out.println("Grade: " + t.grade);
            t = t.next;
        }
    }

    // Delete a student by roll number
    public void delete(int rollno) {
        if (student == null) {
            System.out.println("main.singly_linked_list.student_management.Student list is empty. Nothing to delete.");
            return;
        }

        // If the head node is to be deleted
        if (student.rollno == rollno) {
            student = student.next;
            System.out.println("main.singly_linked_list.student_management.Student with roll number " + rollno + " deleted.");
            return;
        }

        Student current = student;
        Student previous = null;

        while (current != null && current.rollno != rollno) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("main.singly_linked_list.student_management.Student with roll number " + rollno + " not found.");
            return;
        }

        previous.next = current.next;
        System.out.println("main.singly_linked_list.student_management.Student with roll number " + rollno + " deleted.");
    }

    // Display a student by roll number
    public void displayByRoll(int rollno) {
        if (student == null) {
            System.out.println("main.singly_linked_list.student_management.Student list is empty.");
            return;
        }

        Student t = student;
        while (t != null) {
            if (t.rollno == rollno) {
                System.out.println("Details of student with roll number " + rollno + ":");
                System.out.println("Name: " + t.name);
                System.out.println("Age: " + t.age);
                System.out.println("Grade: " + t.grade);
                return;
            }
            t = t.next;
        }

        System.out.println("main.singly_linked_list.student_management.Student with roll number " + rollno + " not found.");
    }

    // Upgrade the grade of a student by roll number
    public void upgradeGrade(int rollno, String grade) {
        if (student == null) {
            System.out.println("main.singly_linked_list.student_management.Student list is empty.");
            return;
        }

        Student t = student;
        while (t != null) {
            if (t.rollno == rollno) {
                t.grade = grade;
                System.out.println("Grade of student with roll number " + rollno + " updated to " + grade + ".");
                return;
            }
            t = t.next;
        }

        System.out.println("main.singly_linked_list.student_management.Student with roll number " + rollno + " not found.");
    }
}
