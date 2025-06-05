package Coding.java;
/*
Write a java program to read a comma-separated values file and print its
contents in table format, replacing commas with tabs or spaces.

Input File:
------
file.csv

Output:
-------
name age
John 20
Jane 25

Explanation:
-------------
File contains:-

name,age
John,20
Jane,25


*/
import java.io.*;
import java.util.Scanner;

public class Day58P7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line.replace(",", " "));
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
