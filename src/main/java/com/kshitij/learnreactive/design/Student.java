package com.kshitij.learnreactive.design;

//public class Student {
//    int age;
//    private int rollNumber;
//    String name;
//    Student(){
//    }
//    public Student(int rollNumber, int age, String name) {
//        this.rollNumber = rollNumber;
//        this.age = age;
//        this.name = name;
//    }
//}

public class Student implements Prototype{
    int age;
    private int rollNumber;
    String name;
    Student(){
    }
    public Student(int rollNumber, int age, String name) {
        this.rollNumber = rollNumber;
        this.age = age;
        this.name = name;
    }
    @Override
    public Prototype clone()
    {
        return new Student(age,rollNumber,name);
    }
}
