package designpatterns.creational.singletion.earlyinitialization;

public class NonThreadSafeCacheSingleton {
	private static NonThreadSafeCacheSingleton cache;

	private NonThreadSafeCacheSingleton() {

	}

	public static NonThreadSafeCacheSingleton getInstance() {
		// Here if getInstance() method is called from two threads and both finds that
		// cache is null then both threads will create
		// a new object, this way objects of singleton will be created which is wrong

		if (cache == null) {
			cache = new NonThreadSafeCacheSingleton();
		}
		return cache;
	}
}
