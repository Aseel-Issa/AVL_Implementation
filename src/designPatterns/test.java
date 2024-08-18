package designPatterns;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		Singleton s1 = Singleton.getInstance();
//		
//		System.out.println(s1);
//		
//Singleton s2 = Singleton.getInstance();
//		
//		System.out.println(s2);
//		
//		SimpleObject so1 = new SimpleObject();
//		SimpleObject so2 = new SimpleObject();
//		
//		System.out.println(so1);
//		System.out.println(so2);
		
		Calculator cal = Calculator.getInstance();
		int result = cal.add(1, 3);
		System.out.println(result);
	}

}
