package designPatterns;

public interface Subject {

	public void register(Observer o);
	
	public void notifyObservers();
	
	public void setPost(String s);
}
