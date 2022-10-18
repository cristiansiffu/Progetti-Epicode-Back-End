package data;

public class Main {

	public static void main(String[] args) {
		Car alphaRomeo = new Car("147", 1900, "ab123cd", 15000, "black", 5);
		Car ferrari = new Car("Ferrari", 99999, "cd123ef", 15000, "red", 10);

		Car[] garage = { alphaRomeo, ferrari };

		getMostExpensiveCar(garage);
		getCarInfo(garage, "cd123ef");
		getCarColor(garage, "red");
	}

	static void getMostExpensiveCar(Car[] car) {
		Car mostExpensiveCar = car[0];
		for (int i = 0; i < car.length; i++) {
			if (car[i].getPrice() > mostExpensiveCar.getPrice()) {
				mostExpensiveCar = car[i];
			}
		}
		mostExpensiveCar.toString();
	}

	static void getCarInfo(Car[] car, String licensePlate) {
		Car info = null;
		for (int i = 0; i < car.length; i++) {
			if (car[i].getLicensePlate().toUpperCase().equals(licensePlate.toUpperCase())) {
				info = car[i];
			}
		}
		info.toString();
	}

	static void getCarColor(Car[] car, String color) {
		Car carColor = null;
		for (int i = 0; i < car.length; i++) {
			if (car[i].getColor().toUpperCase().equals(color.toUpperCase())) {
				carColor = car[i];
			}
		}
		carColor.toString();
	}

}
