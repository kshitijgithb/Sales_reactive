package com.kshitij.learnreactive.design;

public class Main {
    public static void main(String[] args) {
//        Student obj=new Student(20,65,"Ravi");
//        Student cloneObj=new Student();
//        cloneObj.name=obj.name;
        //we cant set rollNumber because it is private.getter methods can also be private.
        //This is the problem in current way of cloning
        /**
         * client has to know all the properties of student class,if student class has 100 instances and only 98 fields to copy.
         * prototype has resolved this problem.
         * *****
         *cloning logic should not be the responsibility of client,class should be responsible for that.
         * There will be one clone method.
         */

        /**
         * Now client don't need to know about the field of Student class,which fields should be copied all things will be taken
         * care by Student class itself.
         */
        Student obj=new Student(26,75,"Ravi");
        Student cloneObj=(Student)obj.clone();
    }
}
/**
 *              Protopye <Interface>
 *                  every class has to implement clone method.
 *                  create a prototype interface and expose a method clone.
 *
 */
