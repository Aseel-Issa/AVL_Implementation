package designPatterns;

public class Calculator {
	
private static Calculator instance;
	
	private Calculator(){}
	
	
	public int add(int num1, int num2) {
		return num1+num2;
	}
	public static Calculator getInstance() {
		if(instance ==null) {
			instance = new Calculator();
		}
		return instance;
	}
}
