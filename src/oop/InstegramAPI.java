package oop;

public class InstegramAPI implements GenericAPI{

	@Override
	public void send(String news) {
		System.out.println("Sending news to instegram: "+news);
		
	}

//	public void send(String news) {
//		System.out.println("Sending news to instegram: "+news);
//	}
	
//	public void sendtoInsta(String news) {
//		System.out.println("Sending news to insta: "+news);
//	}
}
