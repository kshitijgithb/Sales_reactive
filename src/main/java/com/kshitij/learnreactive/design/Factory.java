package com.kshitij.learnreactive.design;

/**
 * It is used when all the object creation and its
 * business logic we need to keep at one place.
 */
public class Factory {
    public static void main(String[] args) {
        ShapeInstanceFactory factoryObj=new ShapeInstanceFactory();
        Shape circleObj= factoryObj.getShapeInstance("Circle");
        circleObj.computeArea();

    }
}

/**
 *  client-->shape factory --->shape-->cirlce,square,rectangle
 *  Suppose we have 1000 classes and using these objects circle,square,rectangle.
 *  if certain condtions are met then create the object of that particular class.
 *  Object creation logic has to be implemented in all these 1000 classes.
 *  The problem is that if any change is required in logic of creation ,then it needs to be changed in all the classes.
 *  ******
 *  Factory pattern solve this.
 *  It will keep all the creation logic within its class and if any change is required we Just need to change that factory class.
 *
 *
 */

interface Shape{
    public void computeArea();
}

 class Square implements Shape{
     @Override
     public void computeArea() {
         System.out.println("Compute Square area");
     }
 }

 class Circle implements Shape
 {
     @Override
     public void computeArea()
     {
         System.out.println("Compute Circle Area");
     }
 }

 class ShapeInstanceFactory{
    public Shape getShapeInstance(String value){
        if(value.equals("Circle")){
            return new Circle();
        }else if(value.equals("Square")){
            return new Square();
        }
        return null;
    }
 }