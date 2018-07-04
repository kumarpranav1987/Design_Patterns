package designpatterns.creational.singletion.lazyinitialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * If Singleton Class is serializable than more than one object of Singleton may
 * be created as one can store a object in file system and deserialize it
 * 
 * @author Pranav.Kumar
 *
 */
public class SerializableSingletonProblem implements Serializable {
	private static final long serialVersionUID = 1L;
	private int value;
	private static SerializableSingletonProblem singleton = new SerializableSingletonProblem();

	private SerializableSingletonProblem() {

	}

	public static SerializableSingletonProblem getInstance() {
		return singleton;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}

class Main {
	public static void main(String[] args) {
		SerializableSingletonProblem object = SerializableSingletonProblem.getInstance();
		object.setValue(1);
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("obj.ser"))) {
			os.writeObject(object);
			object = null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		SerializableSingletonProblem object1 = SerializableSingletonProblem.getInstance();
		object1.setValue(100);
		SerializableSingletonProblem object2 = null;
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("obj.ser"))) {
			object2 = (SerializableSingletonProblem) is.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// We can see that two object of singleton exists which is wrong
		System.out.println("Object1 value=" + object1.getValue() + "   Object2 Value=" + object2.getValue());

	}
}