package Practise.java;

import java.util.*;
/*
Question: Student Grade Analyzer
You are building a system for a school to analyze student performance.

Requirements:
Create a class Student that has the following:

Fields:
String name
int rollNumber
int[] marks (for 5 subjects)
Constructor to initialize the student.

Method double calculateAverage() to return the average of the 5 marks.

Method char getGrade() which returns:

'A' if average ≥ 90

'B' if average ≥ 75

'C' if average ≥ 60

'D' if average ≥ 40

'F' otherwise

A static method Student getTopper(Student[] students) which returns the student with the highest average.

Sample Input:
3
John 101 85 92 78 88 90
Alice 102 95 97 99 100 93
Bob 103 70 65 72 68 60
Sample Output:
John: Average = 86.6, Grade = B
Alice: Average = 96.8, Grade = A
Bob: Average = 67.0, Grade = C

Topper: Alice with average 96.8
 */
public class StudentMarksAnalyzer {
    static class Student {
        String name;
        int rollNum;
        int[] marks;
        Student(String name, int rollNum, int[] marks){
            setName(name);
            setRollNum(rollNum);
            setMarks(marks);
        }
        void setName(String name) {
            this.name = name;
        }
        void setRollNum(int rollNum) {
            this.rollNum = rollNum;
        }
        void setMarks(int[] marks){
            this.marks = marks;
        }
        String getName(){
            return name;
        }
        int getRollNum(){
            return rollNum;
        }
        int[] getMarks(){
            return marks;
        }
        double calculateAverage(){
            return Arrays.stream(marks).average().orElse(0.0);
        }
        char getGrade(){
            double avg = calculateAverage();
            if(avg>=90) return 'A';
            else if(avg>=75) return 'B';
            else if(avg>=60) return 'C';
            else if(avg>=40) return 'D';
            else return 'F';
        }
        @Override
        public String toString(){
            return name+": Average = "+calculateAverage()+", Grade = "+getGrade();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[n];
        for(int i=0;i<n;i++){
            String[] s = sc.nextLine().split(" ");
//            System.out.println(Arrays.toString(s));
            String name = s[0];
            int rollNum = Integer.parseInt(s[1]);
            int[] marks = new int[5];
            for(int j=2;j<=6;j++){
                marks[j-2] = Integer.parseInt(s[j]);
            }
            students[i]= new Student(name, rollNum, marks);
        }
        Arrays.stream(students).forEach(System.out::println);
        Student topper = getTopper(students);
        System.out.println("Topper: "+topper+" with Average: "+topper.calculateAverage());
        sc.close();
    }
    static Student getTopper(Student[] students){
        Student res = null;
        double maxAvg = 0;
        for(Student s: students){
            double avg = s.calculateAverage();
            if(avg>maxAvg){
                res = s;
                maxAvg = avg;
            }
        }
        return res;
    }
}
