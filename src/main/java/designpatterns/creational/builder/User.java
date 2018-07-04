package designpatterns.creational.builder;
//https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
public class User {
	private final String firstName;
	private final String lastName;
	private int age;
	private String phone;
	private String address;

	private User(final UserBuilder userBuilder) {
		this.firstName = userBuilder.firstName;
		this.lastName = userBuilder.lastName;
		this.age = userBuilder.age;
		this.phone = userBuilder.phone;
		this.address = userBuilder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + "]";
	}

	public static class UserBuilder {
		private String firstName;
		private String lastName;
		private int age;
		private String phone;
		private String address;

		public UserBuilder(final String firstName, final String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
			//We can provide meaningful default values to other fields also(Like for phone number 000-000-000 other wise it will be null)
		}

		public UserBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
