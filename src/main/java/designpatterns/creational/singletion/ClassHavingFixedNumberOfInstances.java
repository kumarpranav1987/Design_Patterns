package designpatterns.creational.singletion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * In case of Singleton class only one object of a class can exist , but there
 * could be a scenario where fixed number instances could be there which is
 * greater than one Like for class Direction there could be FOR values EAST WESt
 * NORTH SOUTH In this scenario readresolve method should return appropriate
 * instance of serialized object
 * 
 * @author Pranav.Kumar
 *
 */
public class ClassHavingFixedNumberOfInstances {
	public static void main(String[] args) {
		Direction d = Direction.getDirection(1);
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("direction.ser"))){
			os.writeObject(d);
		} catch (IOException  e) {
			e.printStackTrace();
		} 
		d=null;
		Direction d1 = Direction.getDirection(2);
		
		Direction d2 = null;
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("direction.ser"))){
			d2 = (Direction) is.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(d2);
		System.out.println(d1);
	}
}

class Direction implements Serializable{
	private static final long serialVersionUID = 1L;
	private int value;
	private static final int EAST_VALUE = 1;
	private static final int WEST_VALUE = 2;
	private static final int NORTH_VALUE = 3;
	private static final int SOUTH_VALUE = 4;
	private static final Direction EAST = new Direction(EAST_VALUE);
	private static final Direction WEST = new Direction(WEST_VALUE);
	private static final Direction NORTH = new Direction(NORTH_VALUE);
	private static final Direction SOUTH = new Direction(SOUTH_VALUE);

	private Direction(int value) {
		this.value = value;
	}

	public static Direction getDirection(int value) {
		Direction direction = null;
		switch (value) {
		case 1:
			direction = EAST;
			break;
		case 2:
			direction = WEST;
			break;
		case 3:
			direction = NORTH;
			break;
		case 4:
			direction = SOUTH;
			break;
		}
		return direction;
	}

	// readresolve method is a instance method so object is created and then
	// readResolve method is called so
	// so we can use the value of the object to return appropriate object
	private Object readResolve() throws ObjectStreamException {
		return getDirection(this.value);
	}

	@Override
	public String toString() {
		return "Direction [value=" + value + "]";
	}
	
}