package designpatterns.creational.singletion;

public class ThreadSafeCacheSingletonDoubleLocking {
	private static ThreadSafeCacheSingletonDoubleLocking cache;

	private ThreadSafeCacheSingletonDoubleLocking() {

	}

	private static ThreadSafeCacheSingletonDoubleLocking getInstance() {
		if (cache == null) {
			synchronized (ThreadSafeCacheSingletonDoubleLocking.class) {
				cache = new ThreadSafeCacheSingletonDoubleLocking();
			}
		}
		return cache;
	}
}
