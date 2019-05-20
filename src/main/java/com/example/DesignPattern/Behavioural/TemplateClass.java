package com.example.DesignPattern.Behavioural;

//subclass tells the implemenation steps to parent class
public class TemplateClass {
	public static void main(String[] args) {

		DataProcessor xsl = new XslFile();

		xsl.process();
		DataProcessor xml = new XMLFile();

		xml.process();
	}

}

abstract class DataProcessor {
	public void process() {
		// for sequential execution
		readData();
		processData();
		saveData();
	}

	public abstract void readData();

	public abstract void processData();

	public abstract void saveData();

}

class XslFile extends DataProcessor {
	public void readData() {
		System.out.println("read xsl file");
	}

	public void processData() {
		System.out.println("process xsl file");
	}

	public void saveData() {
		System.out.println("save xsl file");
	}
}

class XMLFile extends DataProcessor {
	public void readData() {
		System.out.println("read XML file");
	}

	public void processData() {
		System.out.println("process XML file");
	}

	public void saveData() {
		System.out.println("save XML file");
	}

}