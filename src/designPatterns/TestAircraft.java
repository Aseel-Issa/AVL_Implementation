package designPatterns;
import java.util.*;
public class TestAircraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aircraft plane = new Plane();		
		Aircraft hc = new Heliocupter();
		
		List<Aircraft> aircrafts = new ArrayList<Aircraft>();
		aircrafts.add(plane);
		aircrafts.add(hc);
		
		for(int i=0; i<aircrafts.size(); i++) {
			aircrafts.get(i).fly();
		}
	}

}
