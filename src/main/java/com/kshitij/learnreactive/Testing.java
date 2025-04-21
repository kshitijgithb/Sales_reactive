package com.kshitij.learnreactive;

public class Testing {
    public static void main(String[] args) {
        methodA();
    }

    static void methodA() {
        methodB();
    }

    static void methodB() {
        int x = 10; // Set a breakpoint here
        System.out.println("Inside methodB");
    }
}
