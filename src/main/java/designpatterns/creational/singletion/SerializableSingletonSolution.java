package designpatterns.creational.singletion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

//https://www.javalobby.org/java/forums/t17491.html
public class SerializableSingletonSolution implements Serializable {
	private static final long serialVersionUID = 1L;
	private int value;
	private static SerializableSingletonSolution singleton = new SerializableSingletonSolution();

	public static SerializableSingletonSolution getInstance() {
		return singleton;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private Object readResolve() throws ObjectStreamException {
		// instead of the object we're on,
		// return the class variable INSTANCE
		return singleton;
	}
}

class MainSerializableSingletonSolution {
	public static void main(String[] args) {
		SerializableSingletonSolution object = SerializableSingletonSolution.getInstance();
		object.setValue(1);
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("obj1.ser"))) {
			os.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		object = null;

		SerializableSingletonSolution object1 = SerializableSingletonSolution.getInstance();
		object1.setValue(100);

		SerializableSingletonSolution object2 = null;
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("obj1.ser"))) {
			object2 = (SerializableSingletonSolution) is.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Here We see we have a single instance of singleton
		System.out.println("Object1 Value = " + object1.getValue() + "   Object2 Value = " + object2.getValue());

	}
}