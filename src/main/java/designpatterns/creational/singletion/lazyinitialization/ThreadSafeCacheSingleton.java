package designpatterns.creational.singletion.lazyinitialization;

public class ThreadSafeCacheSingleton {
	private static ThreadSafeCacheSingleton cache;
	
	private ThreadSafeCacheSingleton() {
		
	}
	//In this case more than one object will not be created in multithreaded scenario which solves the problen of NonThreadSafeCacheSingleton.java
	//But we are synchronizing the whole method which is not necessary
	//Better Implementation in ThreadSafeCacheSingletonDoubleLocking.java
	public synchronized static ThreadSafeCacheSingleton getInstance() {
		if(cache == null) {
			cache = new ThreadSafeCacheSingleton();
		}
		return cache;
	}
}
