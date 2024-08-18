package designPatterns;

public class testFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String type = "wallWatch";
		Watch obj = WatchFactory.createWatch(new HandWatchFactory());
		
	}

}
