package javadesignpatterns.creational.singleton;

/*Lazy initialization: In this method, object is created only if it is needed. This may prevent resource wastage.
An implementation of getInstance() method is required which return the instance. 
There is a null check that if object is not created then create, otherwise return previously created. 
To make sure that class cannot be instantiated in any other way, constructor is made final. As object is created with in a method, 
it ensures that object will not be created until and unless it is required. Instance is kept private so that no one can access it directly. 
It can be used in a single threaded environment because multiple threads can break singleton property as 
they can access get instance method simultaneously and create multiple objects. */

public class LazyInstantiation {

	public static LazyInstantiation instance;
	
	private LazyInstantiation() {
		// as private we cant create objects
	}
	
	public static LazyInstantiation getInstance() {
		
		if(instance == null) {
			instance = new LazyInstantiation();
		}
		
		return instance;
	}
}

/*
 * Pros: Object is created only if it is needed. It may overcome wastage of
 * resource and CPU time. Exception handling is also possible in method. Every
 * time a condition of null has to be checked. instance can’t be accessed
 * directly. In multithreaded environment, it may break singleton property.
 */


/////////////////////////////////////

/*
 * Thread Safe Singleton: A thread safe singleton is created so that singleton
 * property is maintained even in multithreaded environment. To make a singleton
 * class thread safe, getInstance() method is made synchronized so that multiple
 * threads can’t access it simultaneously.
 */


class LazyInstantiation2 {
	
	private static LazyInstantiation2 instance;
	
	private LazyInstantiation2() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static LazyInstantiation2 getInstance() {
		
		if(instance == null) {
			instance = new LazyInstantiation2();
		}
		
		return instance;
	}
}

/*
 * Pros: Lazy initialization is possible. It is also thread safe. getInstance()
 * method is synchronized so it causes slow performance as multiple threads
 * can’t access it simultaneously.
 */


/////////////////////////////////////

class LazyInstantiation3 {
	
	private static LazyInstantiation3 instance;
	
	private LazyInstantiation3() {
		// TODO Auto-generated constructor stub
	}
	
	public static LazyInstantiation3 getInstance() {
		
		if(instance == null) {
			
			//synchronized block to remove overhead
			synchronized (LazyInstantiation3.class) {
				
				if(instance == null) {
					instance = new LazyInstantiation3();
				}
			}
		}
		
		return instance;
	}
}

/*
 * Pros: Lazy initialization is possible. It is also thread safe. Performance
 * overhead gets reduced because of synchronized keyword. First time, it can
 * affect performance.
 */


/////////////////////////////////////

/*
 * Bill Pugh Singleton Implementation: Prior to Java5, memory model had a lot of
 * issues and above methods caused failure in certain scenarios in multithreaded
 * environment. So, Bill Pugh suggested a concept of inner static classes to use
 * for singleton.
 */

class LazyInstantication4 {
	
	private LazyInstantication4() {
		// TODO Auto-generated constructor stub
	}
	
	private static class BillPughSingleton {
		
		private static final LazyInstantication4 instance = new LazyInstantication4();
	}
	
	public static LazyInstantication4 getInstance() {
		
		return BillPughSingleton.instance;
	}
	
	/*
	 * When the singleton class is loaded, inner class is not loaded and hence
	 * doesn’t create object when loading the class. Inner class is created only
	 * when getInstance() method is called. So it may seem like eager initialization
	 * but it is lazy initialization. This is the most widely used approach as it
	 * doesn’t use synchronization.
	 */
}