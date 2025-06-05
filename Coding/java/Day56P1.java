package Coding.java;
/*

Design and implement a Java application to manage a list of students 
along with their subject-wise marks and determine the student who 
has scored the highest total marks.

Your task is to implement getTopper() method only.

Sample Ouput:
----------------
Topper is: Alice (Roll: 101) with total marks: 185

*/
import java.util.*;

public class Day56P1 {
    public static void main(String[] args) {
        Students students = new Students();
        students.readStudentData(); // assume students are populated here

        Students.Student topper = getTopper(students);
        int totalMarks = 0;
        for (Students.Marks m : topper.marks) {
            totalMarks += m.marks;
        }
        System.out.println("Topper is: " + topper + " with total marks: " + totalMarks);
    }

    static Students.Student getTopper(Students students2) {
        // Implement only this method. Do not alter the code.
        List<Students.Student> stds = students2.students;
        int max = 0;
        Students.Student res = null;
        for(Students.Student s: stds){
            List<Students.Marks> marks = s.marks;
            int sum = 0;
            for(Students.Marks m: marks){
                sum += m.marks;
            }
            if(max<sum){
                max = sum;
                res = s;
            }
        }
        return res;
    }
}

class Students {
    List<Student> students;

    public Students() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void readStudentData() {
        // Sample student data setup
        Student s1 = new Student("Alice", 101, Arrays.asList(
                new Marks("Math", 90),
                new Marks("Science", 95)
        ));

        Student s2 = new Student("Bob", 102, Arrays.asList(
                new Marks("Math", 80),
                new Marks("Science", 85)
        ));

        Student s3 = new Student("Charlie", 103, Arrays.asList(
                new Marks("Math", 88),
                new Marks("Science", 92)
        ));

        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    static class Student {
        String name;
        int rollNumber;
        List<Marks> marks;

        public Student(String name, int rollNumber, List<Marks> marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        public String toString() {
            return name + " (Roll: " + rollNumber + ")";
        }
    }

    static class Marks {
        String subject;
        int marks;

        public Marks(String subject, int marks) {
            this.subject = subject;
            this.marks = marks;
        }
    }
}


