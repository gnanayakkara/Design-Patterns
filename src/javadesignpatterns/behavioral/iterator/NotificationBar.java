package javadesignpatterns.behavioral.iterator;

public class NotificationBar {
	
	NotificationCollection notifications;
	
	public NotificationBar(NotificationCollection notifications) {
		this.notifications = notifications;
	}
	
	public void printNotifications() {
		
		Iterator iterator = notifications.createIterator();
		System.out.println(".....NOTIFICATION BAR.....");
		
		while(iterator.hasNext()) {
			Notification notification = (Notification) iterator.next();
			System.out.println(notification.getNotification());
		}
	}

}
