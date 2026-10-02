package com.ds.collectionsJava.oops;

public class StudentRunner {

    public static void main(String[] args) {

        Student s1=new Student(1,"Amrita");
        Student s2=new Student(1,"Amrita");

        System.out.println(s1.equals(s2));

        System.out.println(s1==s2);

        System.out.println(s1.hashCode() +" && "+s2.hashCode());
    }
}
