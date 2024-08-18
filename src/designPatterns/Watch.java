package designPatterns;

public abstract class Watch {
	
	protected int diameter;
	
	public void ticktock() {
		System.out.println("time is passing");
	}
	
	public void reset() {
		System.out.println("time is has been reset");
	}

}
