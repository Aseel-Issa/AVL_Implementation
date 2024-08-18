package designPatterns;
import java.util.*;

public class Blog implements Subject{
	
	String post;
	List<Observer> observers = new ArrayList<Observer>();

	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i = 0; i<observers.size(); i++) {
			observers.get(i).recieveMessage(this.post);
		}
		
	}
	
	public void setPost(String post) {
		this.post = post;
		notifyObservers();
	}

}
