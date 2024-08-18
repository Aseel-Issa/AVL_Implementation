package designPatterns;

public class Plane extends Aircraft{
	
	public Plane() {
		this.type = new Commercial();
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Flying plane at speed: "+this.type.maxSpeed());
		
	}

}
