package designpatterns.creational.singletion.earlyinitialization;

public class Cache {
	private static Cache cache = new Cache();

	private Cache() {

	}

	public static final Cache getInstance() {
		return cache;
	}
}
