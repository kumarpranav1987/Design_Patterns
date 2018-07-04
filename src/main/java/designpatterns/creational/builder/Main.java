package designpatterns.creational.builder;

public class Main {
	public static void main(String[] args) {
		User user = new User.UserBuilder("Pranav", "Kumar").build();
		System.out.println(user);
		User user1 = new User.UserBuilder("Pranav", "Kumar").setAge(10).build();
		System.out.println(user1);
	}
}
