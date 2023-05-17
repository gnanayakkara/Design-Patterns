package javadesignpatterns.creational.singleton;

//Info : https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/

public class EarlyInstantiation {
	
	private static final EarlyInstantiation instance = new EarlyInstantiation();
	
	public static EarlyInstantiation getInstance() {
		return instance;
	}

}

/*
 * Pros: 
 * Very simple to implement. 
 * May lead to resource wastage. Because instance of class is created always, whether it is required or not. 
 * CPU time is also wasted in creation of instance if it is not required. Exception
 * handling is not possible. 
 * 
 * Using static block: This is also a sub part of
 * Eager initialization. The only difference is object is created in a static
 * block so that we can have access on its creation, like exception handling. In
 * this way also, object is created at the time of class loading. It can be used
 * when there is a chance of exceptions in creating object with eager
 * initialization.
 */


class EarlyInstantiation2 {
	
	public static EarlyInstantiation2 instance;
	
	static {
		instance = new EarlyInstantiation2();
	}
}


/*
 * Pros: 
 * Very simple to implement. No need to implement getInstance() method.
 * Instance can be accessed directly. Exceptions can be handled in static block.
 * May lead to resource wastage. Because instance of class is created always,
 * whether it is required or not. CPU time is also wasted in creation of
 * instance if it is not required.
 */