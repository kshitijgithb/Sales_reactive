package com.kshitij.learnreactive.design;

/**
 * It is used when we have to create only one instance of the class.
 * There are 4 ways to achieve this:
 * 1.Eager
 * 2.Lazy
 * 3.Synchronized Method
 * 4.Double Locking  ---> This is actually used in the industry.
 */


/**
 * Eager initialisation
 */
public class Singleton {
    public static void main(String[] args) {
        DBConnection conObject=DBConnection.getInstance();
    }
}
 class DBConnection{
     private static DBConnection conObject=new DBConnection();  //Eagerly initialised this static object,when class loads it will be also initialised.
     private DBConnection(){

     }
     public static DBConnection getInstance(){
         return conObject;
     }
}

/**
 * Lazy initialisation
 * whenever there is a requirement then only creaates the object.By default since it is static during load
 * time it will be initialised with null.
 * But there is a problem , if 2 threads come simultaneously, and check object is null then 2 objects will be created.
 */
class DBConnectionLazy{
    private static DBConnectionLazy conObject;
    private DBConnectionLazy(){

    }
    public static DBConnectionLazy getInstance(){
       if(conObject==null)
       {
           conObject=new DBConnectionLazy();
       }
       return conObject;
    }
}

/**
 * It is thread safe and solve the problems in multithreaded environment.
 * Synchronised put a lock, only one thread go inside at a time.
 * But it is very expensive.
 * if 1000 request comes , then lock will be put evreytime,
 * Hence,it is not used generally.
 * Double Locking is used
 */
class DBConnectionLazySync{
    private static DBConnectionLazySync conObject;
    private DBConnectionLazySync(){

    }
    synchronized static DBConnectionLazySync getInstance(){
        if(conObject==null)
        {
            conObject=new DBConnectionLazySync();
        }
        return conObject;
    }
}


/**
 * It is used in industry
 */
class DBConnectionLazySyncLock{
    private static DBConnectionLazySyncLock conObject;
    private DBConnectionLazySyncLock(){

    }
    public static DBConnectionLazySyncLock
    getInstance(){
        if(conObject==null)
        {
            synchronized (DBConnectionLazySyncLock.class) {
                if(conObject==null) {
                    conObject = new DBConnectionLazySyncLock();
                }
            }
        }
        return conObject;
    }
}