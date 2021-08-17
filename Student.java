
/*
Create a Java class called Student with the following details as variables within it.
(i) USN
(ii) Name
(iii) Programme
(iv) Phone
Write a Java program to create nStudent objects and print the USN, Name, Branch, and Phone of these objects with suitable headings
*/

import java.util.Scanner;

public class Student {
    String usn, name, programee, phone;

    Student(String usn, String name, String programee, String phone) {
        this.usn = usn;
        this.name = name;
        this.programee = programee;
        this.phone = phone;
    }

    void displayRecord() {
        System.out.println(usn + "\t\t" + name + "\t\t" + programee + "\t\t" + phone);
    }

    public static void main(String[] args) {
        Student s[] = new Student[100];
        System.out.println("Enter the no. of students: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter student details: ");
        for (int i = 0; i < n; i++) {
            String usn = sc.next();
            String name = sc.next();
            String programee = sc.next();
            String phone = sc.next();
            s[i] = new Student(usn, name, programee, phone);
        }
        System.out.println("USN\t\tName\t\tBranch\t\tPhone");
        for (int j = 0; j < n; j++) {
            s[j].displayRecord();
        }
        sc.close();
    }
}
