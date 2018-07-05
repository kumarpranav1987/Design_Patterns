package designpatterns.creational.factory;

/**
 * https://howtodoinjava.com/design-patterns/creational/implementing-factory-design-pattern-in-java/
 * 
 * @author Pranav.Kumar
 *
 */
public class FactoryExample1 {
	public static void main(String[] args) {
		Car smallCar = CarFactory.getCar(CarModel.SMALL);
		Car sedanCar = CarFactory.getCar(CarModel.SEDAN);
		Car luxuryCar = CarFactory.getCar(CarModel.LUXURY);
	}
}

enum CarModel {
	SMALL, SEDAN, LUXURY
}

abstract class Car {
	private CarModel model;

	public Car(CarModel model) {
		this.model = model;
	}

	public abstract void construct();
}

class SmallCar extends Car {
	public SmallCar() {
		super(CarModel.SMALL);
		construct();
	}

	@Override
	public void construct() {
		System.out.println("Constructing Small Car");
	}
}

class SedanCar extends Car {
	public SedanCar() {
		super(CarModel.SEDAN);
		construct();
	}

	@Override
	public void construct() {
		System.out.println("Constructing Sedan Car");
	}
}

class LuxuryCar extends Car {

	public LuxuryCar() {
		super(CarModel.LUXURY);
		construct();
	}

	@Override
	public void construct() {
		System.out.println("Constructing Luxury Car");
	}
}

class CarFactory {
	public static Car getCar(CarModel model) {
		Car car = null;
		switch (model) {
		case SMALL:
			car = new SmallCar();
			break;
		case SEDAN:
			car = new SedanCar();
			break;
		case LUXURY:
			car = new LuxuryCar();
			break;
		default:
			break;
		}
		return car;
	}
}