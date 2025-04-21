package com.kshitij.learnreactive.design;

/**
 * It's a factory of factory
 *****
 * Abstract Producer is factory of factory.
 * client--->Abstract Producer--->Abstract Factory--->Economic Car factory,Luxury Car factory
 * Economic car factory,luxury car factory
 * Economic car factory return object of economic cars,Luxury car factory return objects of Luxury cars.
 */

public class FactoryInFactory {
    public static void main(String[] args) {
        AbstractFactoryProducer abstractFactoryProducer=new AbstractFactoryProducer();
        AbstractFactory abstractFactory= abstractFactoryProducer.getFactoryInstance("Premium");
        Car carObj=abstractFactory.getInstance(50000000);
        System.out.println(carObj.getTopSpeed());
    }
}
interface Car{
    public int getTopSpeed();
}
class EconomicCar1 implements Car{
    @Override
    public int getTopSpeed(){
        return 100;
    }
}class EconomicCar2 implements Car{
    @Override
    public int getTopSpeed(){
        return 200;
    }
}class LuxuryCar1 implements Car{
    @Override
    public int getTopSpeed(){
        return 150;
    }
}class LuxuryCar2 implements Car{
    @Override
    public int getTopSpeed(){
        return 300;
    }
}
interface AbstractFactory{
    public Car getInstance(int price);
}
class AbstractFactoryProducer{
    public AbstractFactory getFactoryInstance(String value){
        if(value.equals("Economic")){
            return new EconomicCarFactory();
        }
        else if(value.equals("Luxury")||value.equals("Premium")){
            return new LuxuryCarFactory();
        }
        return new EconomicCarFactory();
    }
}

 class EconomicCarFactory implements AbstractFactory
{
  @Override
    public Car getInstance(int price){
      if(price<=300000)
      {
          return new EconomicCar1();
      }
      else return new EconomicCar2();
  }

}
class LuxuryCarFactory implements AbstractFactory
{
    @Override
    public Car getInstance(int price){
        if(price<=300000)
        {
            return new LuxuryCar1();
        }
        else return new LuxuryCar2();
    }
}
