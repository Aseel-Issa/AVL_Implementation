package designPatterns;

public class User implements Observer{
	
	Subject blog;

	@Override
	public void subscribe(Subject s) {
		// TODO Auto-generated method stub
		this.blog = s;
		s.register(this);
		
	}

	@Override
	public void recieveMessage(String s) {
		// TODO Auto-generated method stub
		System.out.println("I have recieved the following notification: "+s);
		
	}

}
