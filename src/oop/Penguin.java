package oop;

public class Penguin extends Bird{

//	public Penguin() {
//		System.out.println("Hello, i am penguin");
//		System.out.println("canfly = "+this.canFly);
//		System.out.println("canfly = "+super.canFly);
//	}
	public Penguin() {
		super(false);
	}
	
	public void sing() {
		System.out.println("ooooooooooo");
		super.sing();
	}
	
	public void sing(int number) {
		System.out.println(number);
	}
	
	private void eat(String food) {
		
		System.out.println("in private");
		System.out.println("eating "+food);
	}
	
	public void eat() {
		System.out.println("in public");
		this.eat("fish");
	}
}
