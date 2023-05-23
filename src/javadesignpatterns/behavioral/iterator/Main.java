package javadesignpatterns.behavioral.iterator;

public class Main {
	
	//https://www.geeksforgeeks.org/iterator-pattern/

	public static void main(String[] args) {
		
		NotificationCollection nc = new NotificationCollection();
		NotificationBar bar = new NotificationBar(nc);
		
		bar.printNotifications();
	}
}
