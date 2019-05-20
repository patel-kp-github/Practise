package com.example.DesignPattern.Structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeClass {
	public static void main(String[] args) {
		Component ram = new Leaf("Ram", 3000);
		Component hdd = new Leaf("HDD", 5000);
		Component mouse = new Leaf("Mouse", 500);
		Component kb = new Leaf("KeyBoard", 1500);

		Component peripheral = new Composite("peripheral");
		peripheral.addComponent(mouse);
		peripheral.addComponent(kb);

		Component cabinet = new Composite("cabinet");
		cabinet.addComponent(ram);
		cabinet.addComponent(hdd);

		Component computer = new Composite("Computer");
		computer.addComponent(cabinet);
		computer.addComponent(peripheral);
		
		computer.showPrice();
//		ram.showPrice();

	}
}

interface Component {
	void addComponent(Component c);

	void showPrice();
}

class Leaf implements Component {
	String name;
	int price;

	Leaf(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public void addComponent(Component c) {

	}

	@Override
	public void showPrice() {
		System.out.println(name + ":" + price);
	}

}

class Composite implements Component {
	String name;
	List<Component> list = new ArrayList<>();

	Composite(String name) {
		this.name = name;
	}

	@Override
	public void addComponent(Component c) {
		// TODO Auto-generated method stub
		list.add(c);
	}

	@Override
	public void showPrice() {
//		list.forEach(System.out::println);
		for (Component component : list) {
			component.showPrice();
		}
		 

	}

}
