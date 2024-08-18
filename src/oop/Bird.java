package oop;

public class Bird {

	protected boolean canFly=true;
	public Bird(boolean canFly) {
		this.canFly = canFly;
		System.out.println("Hello i am a bird and canFly = "+this.canFly);
	}
	public Bird() {
		
	}
	
	public void sing() {
		System.out.println("tweeeeeeeeet");
	}
	public void sing(String song) {
		System.out.println(song);
	}
}
