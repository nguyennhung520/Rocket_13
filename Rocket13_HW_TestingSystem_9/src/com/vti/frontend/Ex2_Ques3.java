package com.vti.frontend;

import com.vti.entity.Car;

public class Ex2_Ques3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car("Toyota", "8CVN");
		Car.Engine engine = car.new Engine("Crysler");
		System.out.println("Tao car");
		System.out.println("Thong tin car: "+car);
		System.out.println("Thong tin dong co: "+engine);
	}

}
