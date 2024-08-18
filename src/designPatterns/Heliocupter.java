package designPatterns;

public class Heliocupter extends Aircraft{

	
	public Heliocupter() {
		this.type = new Military();
	}
	public Heliocupter(AircraftType type) {
		this.type = type;
	}
	
	public void setType(AircraftType type) {
		this.type = type;
	}
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
		System.out.println("Flying heliocupter at speed: "+this.type.maxSpeed());
		
	}

}
