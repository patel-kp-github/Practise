package com.example.DesignPattern.Structural;

public class AdaptorClass {
	public static void main(String[] args) {
		Charger charger = new ChargerAdoptor();
		IPhoneCharger iphonecharger = new IPhoneCharger(charger);
		iphonecharger.charging();
	}

}

class IPhoneCharger {
	Charger charger;

	IPhoneCharger(Charger charger) {
		this.charger = charger;
	}

	public void charging() {
		charger.charging();
	}
}

class samsungCharger {
	public void charging() {
		System.out.println("Phone is charging");
	}
}

interface Charger {
	public void charging();
}

//making compatible class by implementing charger interface by calling samsung charger class method
class ChargerAdoptor implements Charger {
	samsungCharger sam = new samsungCharger();

	public void charging() {
		sam.charging();
	}
}
