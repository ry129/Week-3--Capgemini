package main.singly_linked_list.student_management;

public class Student {
    String name;
    int age;
    int rollno;
    String grade;
    Student next;

    public Student(String name, int age, int rollno, String grade, Student next) {
        this.name = name;
        this.age = age;
        this.rollno = rollno;
        this.grade = grade;
        this.next = null;
    }
}
